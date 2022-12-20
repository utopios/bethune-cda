package com.example.coursspring.tools;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceHibernate {
    private Session _session;
    public ServiceHibernate()  {
        _session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        return _session;
    }
}
