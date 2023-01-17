package com.example.customerapp.repository;

import com.example.customerapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c from Customer c where c.firstName like :search or c.lastName like :search or c.phone like :search")
    public Customer searchCustomer(@Param("search") String search);
}
