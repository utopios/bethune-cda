package com.example.coursspringapirest.service;

import com.example.coursspringapirest.dto.response.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public List<PersonDTO> getPersons() {
        List<PersonDTO> personDTOS = new ArrayList<>();
        personDTOS.add(PersonDTO.builder().id(1).firstName("toto").lastName("tata")._selfLink("/person/1")._editLink("/person/1").build());
        return personDTOS;
    }
}
