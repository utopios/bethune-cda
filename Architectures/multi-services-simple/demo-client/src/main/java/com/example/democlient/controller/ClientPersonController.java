package com.example.democlient.controller;


import com.example.democlient.Person;
import com.example.democlient.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public ResponseEntity<Person> post(@RequestParam String name) {
        return ResponseEntity.ok(_personService.PostToApi(name));
    }
}
