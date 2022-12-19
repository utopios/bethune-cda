package com.example.coursspring.service;

import com.example.coursspring.entity.Personne;
import com.example.coursspring.interfaces.IPersonneService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Personne2Service implements IPersonneService {

    public List<Personne> getPersonnes() {
        return Arrays.asList(new Personne(3, "toto", "tata"), new Personne(4, "titi", "minet"));
    }
}
