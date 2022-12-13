package com.example.tphopital.repository.impl;

import com.example.tphopital.entity.FicheSoin;

import java.util.List;

public class FicheSoinRepository extends  BaseRepository<FicheSoin>{
    @Override
    public boolean update(FicheSoin element) {
        return false;
    }

    @Override
    public boolean delete(FicheSoin element) {
        return false;
    }

    @Override
    public List<FicheSoin> findAll() {
        return null;
    }

    @Override
    public FicheSoin findById() {
        return null;
    }
}
