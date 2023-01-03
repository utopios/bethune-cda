package com.example.coursspring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("cours-cookie")
public class CookieController {


    @GetMapping("ecrire")
    public String writeCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "Ihab");
        //La durée de vie du cookie
        cookie.setMaxAge(365*24*3600);
        //Si la durée de vie est à 0, le cookie sera supprimé
        //cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "cookie writed";
    }

    @GetMapping("ecrire-list")
    public String writeCookieList(HttpServletResponse response) throws JsonProcessingException, UnsupportedEncodingException {
        List<String> stringList = Arrays.asList("toto","tata", "titi");
        //Convertion d'un objet en json avec api jackson
        ObjectMapper mapper = new ObjectMapper();
        String stringListJson = mapper.writeValueAsString(stringList);
        Cookie cookie = new Cookie("name", URLEncoder.encode(stringListJson, "UTF-8"));
        //La durée de vie du cookie
        cookie.setMaxAge(365*24*3600);
        //Si la durée de vie est à 0, le cookie sera supprimé
        //cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "cookie writed";
    }

    @GetMapping("lire")
    public String lireCookie(@CookieValue(value = "name") String name, HttpServletRequest request) {
        String response = "";
        //2ème façon pour lire les cookies on peut utiliser un servletRequest
        for(Cookie cookie : request.getCookies()) {
            response += " "+ cookie.getValue();
        }
        return response;
    }
}
