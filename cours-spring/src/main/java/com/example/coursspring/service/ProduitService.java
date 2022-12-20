package com.example.coursspring.service;


import com.example.coursspring.entity.Produit;
import com.example.coursspring.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public class ProduitService extends BaseService implements IDAO<Produit> {

    public ProduitService() {
        super();
    }
    @Override
    public boolean create(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        session = sessionFactory.openSession();
        produit = (Produit) session.get(Produit.class, id);
        session.close();
        return produit;
    }



    @Override
    public List<Produit> findAll() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Produit> produitQuery = session.createQuery("from Produit");
        session.getTransaction().commit();
        return produitQuery.list();
    }




}
