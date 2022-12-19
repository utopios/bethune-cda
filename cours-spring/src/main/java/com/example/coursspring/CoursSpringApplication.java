package com.example.coursspring;

import com.example.coursspring.classe.MaClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SpringBootApplication
public class CoursSpringApplication {

    @Autowired
    private static MaClasse maClasse;
    public static void main(String[] args) {
        SpringApplication.run(CoursSpringApplication.class, args);
        maClasse.getClass();
    }

}
