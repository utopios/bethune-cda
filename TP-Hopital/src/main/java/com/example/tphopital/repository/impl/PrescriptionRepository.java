package com.example.tphopital.repository.impl;

import com.example.tphopital.entity.Prescription;

import java.util.List;

public class PrescriptionRepository extends BaseRepository<Prescription>{
    @Override
    public boolean update(Prescription element) {
        return false;
    }

    @Override
    public boolean delete(Prescription element) {
        return false;
    }

    @Override
    public List<Prescription> findAll() {
        return null;
    }

    @Override
    public Prescription findById() {
        return null;
    }
}
