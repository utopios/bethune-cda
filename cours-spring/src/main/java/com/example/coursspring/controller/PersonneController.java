package com.example.coursspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/personne")
public class PersonneController {

    //@RequestMapping(path = "/personnes", method = RequestMethod.GET)
    //@GetMapping("/personne")
    @GetMapping("")
    public String getPersonnes() {
        return "Je suis une action qui affiche une liste de personnes";
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
