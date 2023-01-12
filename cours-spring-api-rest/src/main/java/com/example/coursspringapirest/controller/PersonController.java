package com.example.coursspringapirest.controller;

import com.example.coursspringapirest.dto.response.PersonDTO;
import com.example.coursspringapirest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonService _personServie;

    @GetMapping("")
    public ResponseEntity<List<PersonDTO>> get() {
        return ResponseEntity.ok(_personServie.getPersons());
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDTO> getElement(@PathVariable int id) {
        return ResponseEntity.ok(PersonDTO.builder().id(1).build());
    }
}
