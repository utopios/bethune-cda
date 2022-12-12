package com.example.tphopital.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSession {
    private static Session instance = null;
    private StandardServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;
    private HibernateSession() {
        serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        instance = sessionFactory.openSession();
    }

    public static Session getInstance() {
        if(instance == null)
            new HibernateSession();
        return instance;
    }


}
