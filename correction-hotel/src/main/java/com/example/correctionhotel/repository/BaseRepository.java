package com.example.correctionhotel.repository;

import com.example.correctionhotel.util.hibernate.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepository<T> {

    protected Session _session;
    protected ServiceHibernate _serviceHibernate;

    public BaseRepository(ServiceHibernate serviceHibernate) {
        _serviceHibernate = serviceHibernate;
        _session = _serviceHibernate.getSession();
    }

    public void create(T element) {
        _session.beginTransaction();
        _session.persist(element);
        _session.getTransaction().commit();
    }

    public void update(T element) {
        _session.beginTransaction();
        _session.update(element);
        _session.getTransaction().commit();
    }

    public void delete(T element) {
        _session.beginTransaction();
        _session.delete(element);
        _session.getTransaction().commit();
    }


    public T findById(int id, Class<T> type) {
        return (T)_session.get(type, id);
    }
}
