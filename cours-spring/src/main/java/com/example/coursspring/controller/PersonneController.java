package com.example.coursspring.controller;

import com.example.coursspring.entity.Personne;
import com.example.coursspring.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    private PersonneService personneService;
    //@RequestMapping(path = "/personnes", method = RequestMethod.GET)
    //@GetMapping("/personne")
    @GetMapping("")
    public List<Personne> getPersonnes() {
        return  personneService.getPersonnes();
    }

    //@GetMapping("/personne/1")
    @GetMapping("/1")
    public String getPersonne() {
        return "Je suis une action qui affiche une seule personne";
    }

    //@PostMapping("/personne")
    @PostMapping("")
    public String postPersonne() {
        return "Je suis une action pour poster une personne";
    }
}
