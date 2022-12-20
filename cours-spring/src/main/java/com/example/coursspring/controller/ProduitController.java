package com.example.coursspring.controller;

import com.example.coursspring.entity.Produit;
import com.example.coursspring.interfaces.IDAO;
import com.example.coursspring.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable("id") Integer id) {
        return produitService.findById(id);
    }

    @GetMapping("/getproduit")
    public Produit getProduitByParams(@RequestParam("id") Integer id) {
        return produitService.findById(id);
    }

    @GetMapping ("/delete/{id}")
    public String deleteProduit(@PathVariable("id") Integer id) {
        Produit p = produitService.findById(id);
        if(p != null && produitService.delete(p)) {
            return "Suppression Ok";
        }
        return "Aucun produit avec cet id";
    }
}
