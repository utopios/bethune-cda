package com.example.coursspring.controller;

import com.example.coursspring.entity.Produit;
import com.example.coursspring.interfaces.IDAO;
import com.example.coursspring.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/produit")
@ResponseBody
public class ProduitController {

    @Autowired
    ProduitService produitService;
    @GetMapping("")
    public List<Produit> getProduits() {
        return produitService.findAll();
    }
}
