package com.example.coursspringdata.controller;

import com.example.coursspringdata.entity.Personne;
import com.example.coursspringdata.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("personne")
public class PersonneController {

    @Autowired
    private PersonneRepository personneRepository;

    @PostMapping("")
    public Personne save(@RequestBody Personne personne) {
        personneRepository.save(personne);
        return personne;
    }

    @GetMapping("{nom}")
    public List<Personne> get(@PathVariable String nom) {
        return personneRepository.findPersonnesByNom(nom);
    }

    @GetMapping("{nom}/{prenom}")
    public List<Personne> search(@PathVariable String nom, @PathVariable String prenom) {
        return personneRepository.findPersonnesByNomContainingOrPrenomContaining(nom, prenom);
    }
}
