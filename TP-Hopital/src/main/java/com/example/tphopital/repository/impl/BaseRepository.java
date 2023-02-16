package com.example.tphopital.repository.impl;

import com.example.tphopital.repository.IRepository;
import com.example.tphopital.util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

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

    public List<T> findAll() {
        Session session = HibernateSession.getInstance();
        //CriteriaBuilder cb = session.getCriteriaBuilder();
        Query<T> query = session.createQuery("from Patient ");
        return query.getResultList();

    }

    public void setTransaction(Transaction _transaction) {
        this._transaction = _transaction;
    }
}
