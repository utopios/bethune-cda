package com.example.coursspring.classe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MaClasse {
    @Autowired
    IClasseA classeA;

    @Autowired
    IClasseB classeB;

    /*public IClasseA getClasseA() {
        return classeA;
    }

    public void setClasseA(IClasseA classeA) {
        this.classeA = classeA;
    }

    public IClasseB getClasseB() {
        return classeB;
    }

    public void setClasseB(IClasseB classeB) {
        this.classeB = classeB;
    }*/
}
