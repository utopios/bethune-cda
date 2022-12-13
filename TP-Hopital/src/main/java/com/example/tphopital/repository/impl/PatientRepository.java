package com.example.tphopital.repository.impl;

import com.example.tphopital.entity.Patient;
import org.hibernate.Transaction;

import java.util.List;

public class PatientRepository extends BaseRepository<Patient> {

    public PatientRepository() {
        super();
    }
    public PatientRepository(Transaction transaction) {
        super(transaction);
    }
    @Override
    public boolean update(Patient element) {
        return false;
    }

    @Override
    public boolean delete(Patient element) {
        return false;
    }

    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public Patient findById() {
        return null;
    }
}
