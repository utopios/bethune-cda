package com.example.tphopital.repository.impl;

import com.example.tphopital.entity.OperationAnalyse;

import java.util.List;

public class OperationAnalyseRepository extends BaseRepository<OperationAnalyse>{
    @Override
    public boolean update(OperationAnalyse element) {
        return false;
    }

    @Override
    public boolean delete(OperationAnalyse element) {
        return false;
    }

    @Override
    public List<OperationAnalyse> findAll() {
        return null;
    }

    @Override
    public OperationAnalyse findById() {
        return null;
    }
}
