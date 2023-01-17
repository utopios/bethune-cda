package com.example.customerapp.service;


import com.example.customerapp.dto.request.RequestCustomerDTO;
import com.example.customerapp.dto.response.ResponseCustomerDTO;
import com.example.customerapp.entity.Customer;
import com.example.customerapp.exception.NotFoundException;
import com.example.customerapp.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository _customerRepository;
    @Autowired
    private ModelMapper _modelMapper;


    @Override
    public ResponseCustomerDTO createCustomer(RequestCustomerDTO customerDTO) {
        return _modelMapper.map(_customerRepository.save(_modelMapper.map(customerDTO, Customer.class)), ResponseCustomerDTO.class);
    }

    @Override
    public ResponseCustomerDTO getCustomer(String search) throws NotFoundException {
        Customer customer = _customerRepository.searchCustomer(search);
        if(customer == null) {
            throw new NotFoundException();
        }
        return _modelMapper.map(customer, ResponseCustomerDTO.class);
    }
}
