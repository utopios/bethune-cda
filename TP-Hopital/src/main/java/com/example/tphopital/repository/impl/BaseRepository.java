package com.example.tphopital.repository.impl;

import com.example.tphopital.repository.IRepository;
import com.example.tphopital.util.HibernateSession;
import org.hibernate.Transaction;

import java.io.Serializable;

public abstract class BaseRepository<T> implements IRepository<T> {

    protected Transaction transaction;
    protected BaseRepository() {
        transaction = HibernateSession.getInstance().beginTransaction();
    }
    @Override
    public boolean create(T element) {
        Serializable s = HibernateSession.getInstance().save(element);
        transaction.commit();
        HibernateSession.getInstance().close();
        return s != null;
    }


}
