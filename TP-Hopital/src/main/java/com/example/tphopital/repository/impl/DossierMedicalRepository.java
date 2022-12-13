package com.example.tphopital.repository.impl;

import com.example.tphopital.entity.DossierMedical;

import java.util.List;

public class DossierMedicalRepository extends BaseRepository<DossierMedical>{
    @Override
    public boolean update(DossierMedical element) {
        return false;
    }

    @Override
    public boolean delete(DossierMedical element) {
        return false;
    }

    @Override
    public List<DossierMedical> findAll() {
        return null;
    }

    @Override
    public DossierMedical findById() {
        return null;
    }
}
