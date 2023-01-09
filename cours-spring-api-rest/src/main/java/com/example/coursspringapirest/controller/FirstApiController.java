package com.example.coursspringapirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("first")
public class FirstApiController {

    /*@GetMapping()
    public String get() {
        return "verbe Get";
    }*/

    @GetMapping()
    public ResponseEntity<String> get() {
        //return ResponseEntity.ok().body("tout est ok");
        return ResponseEntity.status(204).body("tout est ok");
    }

    @PostMapping()
    public String post() {
        return "verb post";
    }

    @PutMapping()
    public ResponseEntity<String> put() {
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping()
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(401).body("not Allowed");
    }

}
