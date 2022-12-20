package com.example.coursspring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;


public abstract class BaseService {
    protected StandardServiceRegistry registre;
    protected SessionFactory sessionFactory;
    protected Session session;

    protected BaseService() {
           registre= new StandardServiceRegistryBuilder().configure().build();
           sessionFactory= new MetadataSources(registre). buildMetadata(). buildSessionFactory();
    }
}
