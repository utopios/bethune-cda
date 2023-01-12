package com.example.coursspringapirest.service;

import com.example.coursspringapirest.controller.PersonController;
import com.example.coursspringapirest.dto.response.PersonDTO;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Service
public class PersonService {

    public List<PersonDTO> getPersons() {
        List<PersonDTO> personDTOS = new ArrayList<>();
        PersonDTO personDTO = PersonDTO.builder().id(1).firstName("toto").lastName("tata").build();
        //Link link = linkTo(PersonController.class).slash(personDTO.getId()).withSelfRel();
        Link link = linkTo(methodOn(PersonController.class).getElement(personDTO.getId())).withSelfRel();
        personDTO.add(link);
        personDTOS.add(personDTO);
        return personDTOS;
    }
}
