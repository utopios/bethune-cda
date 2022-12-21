package com.example.coursspring.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("personne-html")
public class PersonneAvecVueController {
    /*@GetMapping("")
    public String getPersonnesSousFormathtml() {
        return "index";
    }*/

    @GetMapping("")
    public ModelAndView getPersonnesSousFormathtml() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
