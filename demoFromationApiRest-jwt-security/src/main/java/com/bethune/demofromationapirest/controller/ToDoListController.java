package com.bethune.demofromationapirest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Annotation pour indiquer à Spring d'utiliser cette classe comme un controller
@RestController
//Annotation pour indiquer à Spring d'utiliser cette class pour répondre à l'url /todolists
@RequestMapping("/todolists")
public class ToDoListController {


    //Annotation pour répondre à /todolists/first avec le verbe http GET
    @GetMapping("/first")
    public String firstAction() {
        return  "hello from our first end point";
    }

    //Annotation pour répondre à /todolists/second avec le verbe http GET
    @GetMapping("/second")
    public String secondAction()  {
        return "hello from our second end point";
    }
}
