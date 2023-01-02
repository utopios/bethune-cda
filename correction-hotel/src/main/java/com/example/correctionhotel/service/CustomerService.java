package com.example.correctionhotel.service;

import com.example.correctionhotel.entity.Customer;
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
        else {
            Customer customer = new Customer();
            try {
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setPhone(phone);
                _customerRepository.create(customer);
                return true;
            }catch (Exception ex) {
                return false;
            }
        }

    }
}
