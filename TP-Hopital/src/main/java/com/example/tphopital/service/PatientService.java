package com.example.tphopital.service;

import com.example.tphopital.entity.Patient;
import com.example.tphopital.exception.StringFormatException;
import com.example.tphopital.repository.impl.BaseRepository;
import com.example.tphopital.repository.impl.PatientRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientService {

    private BaseRepository<Patient> _patientRepository;

    public PatientService(BaseRepository<Patient> patientBaseRepository) {
        _patientRepository = patientBaseRepository;
    }

    public boolean add(String nom, String prenom, String telephone, String adresse, String nss, String dateNaissance, String sexe) throws StringFormatException, ParseException {
        //Logique métier
        Patient patient = new Patient();
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setNss(nss);
        patient.setAdresse(adresse);
        patient.setSexe(sexe.charAt(0));
        patient.setNumeroTelephone(telephone);
        Date dateN = new SimpleDateFormat("dd/mm/yyyy").parse(dateNaissance);
        return _patientRepository.create(patient);
    }
}
