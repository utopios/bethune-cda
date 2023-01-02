package com.example.correctionhotel.repository;

import com.example.correctionhotel.entity.Customer;
import com.example.correctionhotel.entity.Room;
import com.example.correctionhotel.util.hibernate.ServiceHibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository extends BaseRepository<Customer> {
    public CustomerRepository(ServiceHibernate serviceHibernate) {
        super(serviceHibernate);
    }

    public List<Customer> findAll() {
        Query<Customer> query = _session.createQuery("from Customer", Customer.class);
        return query.list();
    }
}
