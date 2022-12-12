package com.example.tphopital.service;

import com.example.tphopital.entity.Patient;
import com.example.tphopital.repository.impl.BaseRepository;
import com.example.tphopital.repository.impl.PatientRepository;

public class PatientService {

    private BaseRepository<Patient> _patientRepository;

    public PatientService(BaseRepository<Patient> patientBaseRepository) {
        _patientRepository = patientBaseRepository;
    }

    public boolean add(Patient patient) {
        //Logique métier
        return _patientRepository.create(patient);
    }
}
