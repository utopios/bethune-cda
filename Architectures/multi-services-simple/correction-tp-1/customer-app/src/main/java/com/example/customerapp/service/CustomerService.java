package com.example.customerapp.service;


import com.example.customerapp.dto.request.RequestCustomerDTO;
import com.example.customerapp.dto.response.ResponseCustomerDTO;
import com.example.customerapp.exception.NotFoundException;

public interface CustomerService {

    public ResponseCustomerDTO createCustomer(RequestCustomerDTO customerDTO);

    public ResponseCustomerDTO getCustomer(String search) throws NotFoundException;
    public ResponseCustomerDTO getCustomer(int id) throws NotFoundException;

}
