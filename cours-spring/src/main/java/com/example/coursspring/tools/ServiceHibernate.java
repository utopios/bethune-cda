package com.example.coursspring.tools;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/*@Component
@RequestScope*/
@Service
public class ServiceHibernate {
    private Session _session;
    public ServiceHibernate()  {
        try {
            _session = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
