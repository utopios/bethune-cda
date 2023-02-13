package com.bethune.demofromationapirest.controller;

import com.bethune.demofromationapirest.dto.ClientDTO;
import com.bethune.demofromationapirest.exception.CustomNotFoundException;
import com.bethune.demofromationapirest.model.Client;
import com.bethune.demofromationapirest.repository.ClientRepository;
import com.bethune.demofromationapirest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    //Annotation pour demander au conteneur spring de créer un objet pour nous (soit à partir d'une classe ou d'une interface)
    @Autowired
    //private ClientRepository clientRepository;
    private ClientService clientService;

    //Récupérer la totalité des clients
    @GetMapping("")
    public List<Client> getClients() {
        //return (List<Client>) clientRepository.findAll();
        return clientService.getAllClient();
    }


    //Récupérer un client par son id
    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable("id") Integer id) {

       // Client client = clientRepository.findById(id).get();
        try {
            ClientDTO client = clientService.getClientById(id);
            //Service 2 Adresse par exemple
            return new ResponseEntity<>(client, HttpStatus.OK);
        }catch (CustomNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }catch(Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
        }
    }


    //Ajouter un client

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public ResponseEntity<Client> postClient(@RequestBody Client client) {
       //On enregistre le client dans la base à l'aide de notre repository
        //clientRepository.save(client);
        clientService.createClient(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    //Modifier un client
    @PutMapping("/{id}")
    public String putClient(@PathVariable("id") Integer id, @RequestBody Client client) {
        /*Client clientExist = clientRepository.findById(id).get();
        clientExist.setNom(client.getNom());
        clientExist.setPrenom(client.getPrenom());
        clientExist.setTelephone(client.getTelephone());
        clientRepository.save(clientExist);*/
        clientService.updateClient(client, id);
        return "ok put "+id;
    }

    //Supprimer un client
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable("id") Integer id) {
        /*Client client = clientRepository.findById(id).get();
        clientRepository.delete(client);*/
        clientService.deleteClient(id);
        return  "ok delete "+id;
    }

}
