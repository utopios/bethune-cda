package com.example.coursspring.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {

    @Autowired
    private HttpServletRequest request;

    public String getColor() {
        String color = "";
        for(Cookie cookie : request.getCookies())
        {
            if(cookie.getName().equals("color")) {
                color = cookie.getValue();
                break;
            }
        }
        return color;
    }
}
