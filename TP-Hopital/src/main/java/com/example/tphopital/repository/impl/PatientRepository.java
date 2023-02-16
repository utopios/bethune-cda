package com.example.tphopital.repository.impl;

import com.example.tphopital.entity.Patient;
import com.example.tphopital.util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

        Session session = HibernateSession.getInstance();
        //CriteriaBuilder cb = session.getCriteriaBuilder();
        Query<Patient> query = session.createQuery("from Patient ");
        return query.getResultList();
    }

    @Override
    public Patient findById() {
        return null;
    }
}
