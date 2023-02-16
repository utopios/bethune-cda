package com.example.tphopital.service;


import com.example.tphopital.entity.Patient;
import com.example.tphopital.exception.StringFormatException;
import com.example.tphopital.repository.impl.BaseRepository;
import com.example.tphopital.repository.impl.PatientRepository;
import com.example.tphopital.util.HibernateSession;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PatientService {

    private BaseRepository<Patient> _patientRepository;

    public PatientService(BaseRepository<Patient> patientBaseRepository) {
        _patientRepository = patientBaseRepository;
        _patientRepository.setTransaction(HibernateSession.getInstance().beginTransaction());
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
        Date dateN = new SimpleDateFormat("yyyy-mm-dd").parse(dateNaissance);
        patient.setDateNaissance(dateN);
        return _patientRepository.create(patient);
    }

    public List<Patient> getAll() {
        return _patientRepository.findAll();
    }
}
