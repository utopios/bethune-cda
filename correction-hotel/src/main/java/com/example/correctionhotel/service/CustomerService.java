package com.example.correctionhotel.service;

import com.example.correctionhotel.repository.CustomerRepository;
import com.example.correctionhotel.util.exceptions.ErrorFieldException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository _customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        _customerRepository = customerRepository;
    }

    public boolean create(String firstName, String lastName, String phone) throws Exception {
        if(firstName == "" || lastName == "" || phone == "") {
            throw new ErrorFieldException();
        }
        return true;
    }
}
