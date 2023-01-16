package com.example.demo.controller;


import com.example.demo.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("api/person")
public class PersonController {

    @GetMapping("")
    ResponseEntity<List<Person>> get() {
        return ResponseEntity.ok(Arrays.asList(Person.builder().name("toto").build(), Person.builder().name("tata").build()));
    }


    @PostMapping("")
    ResponseEntity<Person> post(@RequestBody Person person) {
        return ResponseEntity.ok(Person.builder().name(person.getName()).phone("0101010101").build());
    }
}
