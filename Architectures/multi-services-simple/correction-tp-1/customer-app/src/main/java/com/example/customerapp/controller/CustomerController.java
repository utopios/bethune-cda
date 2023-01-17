package com.example.customerapp.controller;


import com.example.customerapp.dto.request.RequestCustomerDTO;
import com.example.customerapp.dto.response.ResponseCustomerDTO;
import com.example.customerapp.exception.NotFoundException;
import com.example.customerapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")

@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
public class CustomerController {
    @Autowired
    private CustomerService _customerService;

    @PostMapping("")
    public ResponseEntity<ResponseCustomerDTO> post(@RequestBody RequestCustomerDTO customerDTO) {
        return ResponseEntity.ok(_customerService.createCustomer(customerDTO));
    }

    @GetMapping("{search}")
    public ResponseEntity<ResponseCustomerDTO> get(@PathVariable String search) {
        try {
            return ResponseEntity.ok(_customerService.getCustomer(search + "%"));
        }catch (NotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }


}
