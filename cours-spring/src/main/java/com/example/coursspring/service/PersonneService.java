package com.example.coursspring.service;

import com.example.coursspring.entity.Personne;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonneService {

    public List<Personne> getPersonnes() {
        return Arrays.asList(new Personne(1, "toto", "tata"), new Personne(2, "titi", "minet"));
    }
}
