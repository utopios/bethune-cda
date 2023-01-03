package com.example.coursspring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("http-session")
@ResponseBody
public class SessionController {

    @Autowired
    private HttpSession _httpSession;

    @GetMapping("ecrire")
    public String write() {
        _httpSession.setAttribute("name", "ihab");
        return "Ok";
    }

    @GetMapping("ecrire-list")
    public String writeList() {
        List<String> stringList = Arrays.asList("toto","tata", "titi");
        _httpSession.setAttribute("liste", stringList);
        return "Ok";
    }

    @GetMapping("lire")
    public String read() {
        return _httpSession.getAttribute("name").toString();
    }

    @GetMapping("lire-list")
    public List<String> readList() {
        return (List<String>) _httpSession.getAttribute("liste");
    }
    @GetMapping("supprimer")
    public String remove() {
        _httpSession.removeAttribute("name");
        return "suppression Ok";
    }

}
