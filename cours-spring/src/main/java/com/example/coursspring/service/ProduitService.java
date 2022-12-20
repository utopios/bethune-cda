package com.example.coursspring.service;


import com.example.coursspring.entity.Produit;
import com.example.coursspring.interfaces.IDAO;
import com.example.coursspring.tools.ServiceHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;
import java.util.List;

/*@Component
@RequestScope*/
@Service
//Scope => par session
public class ProduitService implements IDAO<Produit> {

    //@Autowired
    private ServiceHibernate serviceHibernate;
    private Session session;
    public ProduitService(ServiceHibernate serviceHibernate){
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }
    @Override
    public boolean create(Produit o) {

        session.beginTransaction();
        //session.save(o);
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Produit o) {

        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Produit o) {

        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;

        produit = (Produit) session.get(Produit.class, id);
        //session.close();
        return produit;
    }



    @Override
    public List<Produit> findAll() {

        //session.beginTransaction();
        Query<Produit> produitQuery = session.createQuery("from Produit", Produit.class);

        return produitQuery.list();
    }




}
