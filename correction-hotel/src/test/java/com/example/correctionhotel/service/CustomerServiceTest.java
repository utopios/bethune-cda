package com.example.correctionhotel.service;

import com.example.correctionhotel.entity.Customer;
import com.example.correctionhotel.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public class CustomerServiceTest {

    private CustomerService customerService;
    private Customer customer;
    @Mock
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        //Arrange
        customerService = new CustomerService(customerRepository);
        Mockito.doNothing().when(customerRepository).create(customer);
    }
    //Test 1, un des champs est vide => lever une exception
    @Test
    void createShouldRaiseExceptionWhenEmptyFields() {
        //Act with Assert
        Assertions.assertThrowsExactly(Exception.class, () -> {
            customerService.create("","", "");
        });
    }
    //Test 2, creation fonctionne avec un boolean

    //Test 3, erreur si exception avec repository
}
