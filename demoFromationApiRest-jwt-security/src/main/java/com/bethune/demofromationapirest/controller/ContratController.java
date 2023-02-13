package com.bethune.demofromationapirest.controller;

import com.bethune.demofromationapirest.model.Contrat;
import com.bethune.demofromationapirest.service.ContratService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public class ContratController {
    private static final Logger logger = LoggerFactory.getLogger(ContratController.class);

    @Autowired
    ContratService contratService;




    @RequestMapping(value = "/contrats", method = RequestMethod.GET)
    public ResponseEntity<List<Contrat>> getAllContrat() {

        logger.info(" --- Methode getAllContrat --- ");
        List<Contrat> contrats = contratService.getListContrat();
        HttpHeaders headers = new HttpHeaders();
        if (!contrats.isEmpty()) {
            headers.add("Custom-Header", "Contrat list is not empty");
        } else {
            headers.add("Custom-Header", "Contrat list is empty");
        }
        return new ResponseEntity<List<Contrat>>(contrats, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/contrat/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contrat> getContratById(@PathVariable("id") Integer idContrat) {
        Optional<Contrat> client = contratService.getContratById(idContrat);

        logger.info(" --- Methode getContratById --- ");
        logger.info(" --- L'id du contrat est " + idContrat);

        return new ResponseEntity<Contrat>(client.get(), HttpStatus.OK);
    }


    @RequestMapping(value = "/contrat", method = RequestMethod.POST)
    public ResponseEntity<Contrat> createOrUpdateContrat(@RequestBody Contrat contrat) {

        logger.info(" --- Methode creationOrUpdateContrat --- ");

        if (contrat.getId() != null) {
            Contrat contratModifie = contratService.modifyContrat(contrat);
            logger.debug("L'id du contrat modifié est " + contratModifie.getId());
            return new ResponseEntity<Contrat>(contratModifie, HttpStatus.OK);
        }

        Contrat contratCree = contratService.createContrat(contrat);
        logger.info("L'id du contrat crée est " + contratCree.getId());
        return new ResponseEntity<Contrat>(contratCree, HttpStatus.OK);
    }


    /*@RequestMapping(value = "/delete-contrat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> deleteContratById(@PathVariable("id") Integer idContrat) throws LocalException {

        boolean isDelete = true;
        logger.info("-- L'id du contrat a supprimé est : " + idContrat);
        Optional<Contrat> contrat = contratService.getContratById(idContrat);


        if (!contrat.isPresent()) {

            throw new LocalException("Le contrat n'existe pas");
        }


        Contrat contrat1 = contratService.getContratById(idContrat).get();
        List<Inscription> inscriptions = inscriptionService.getInscriptionByContrat(contrat1);

        if (!inscriptions.isEmpty()) {
            logger.info("-- Le nombre d'inscription est  : " + inscriptions.size());
            inscriptions.forEach(inscription -> {

                inscriptionService.deleteInscription(inscription.getId());

            });

        }

        List<Inscription> inscription2s = inscriptionService.getInscriptionByContrat(contrat1);

        if (inscription2s.isEmpty()) {
            logger.info("-- Le nombre d'inscription est  : " + inscription2s.size());
            logger.info("-- phase de supression du contrat");
            contratService.deleteContrat(idContrat);
            logger.info("-- Le contrat est supprimé : " + isDelete);

        }


        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Contrat has been deleted"), HttpStatus.OK);

    }*/
}
