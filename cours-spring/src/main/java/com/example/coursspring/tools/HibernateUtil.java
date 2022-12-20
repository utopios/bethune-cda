package com.example.coursspring.tools;

import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("static/hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception | HibernateException e) {
            throw new RuntimeException(e);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
