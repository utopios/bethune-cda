package com.example.coursspring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("lire")
    public String read() {
        return _httpSession.getAttribute("name").toString();
    }
    @GetMapping("supprimer")
    public String remove() {
        _httpSession.removeAttribute("name");
        return "suppression Ok";
    }

}
