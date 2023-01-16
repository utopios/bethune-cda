package com.example.democlient.controller;


import com.example.democlient.Person;
import com.example.democlient.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientPersonController {
    @Autowired
    private PersonService _personService;

    @GetMapping("")
    public ResponseEntity<Person[]> get() {
        return ResponseEntity.ok(_personService.getFromApi());
    }
}
