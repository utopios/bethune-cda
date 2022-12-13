package com.example.tphopital.repository.impl;

import com.example.tphopital.repository.IRepository;
import com.example.tphopital.util.HibernateSession;
import org.hibernate.Transaction;

import java.io.Serializable;

public abstract class BaseRepository<T> implements IRepository<T> {
    protected Transaction _transaction;
    protected BaseRepository() {

    }
    protected BaseRepository(Transaction transaction) {
        _transaction = transaction;
    }
    @Override
    public boolean create(T element) {
        Serializable s = HibernateSession.getInstance().save(element);
        _transaction.commit();
        HibernateSession.getInstance().close();
        return s != null;
    }

    public void setTransaction(Transaction _transaction) {
        this._transaction = _transaction;
    }
}
