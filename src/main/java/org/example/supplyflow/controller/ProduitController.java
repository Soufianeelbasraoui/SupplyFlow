package org.example.supplyflow.controller;

import org.example.supplyflow.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    private  ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public String listProduits(Model model) {
        model.addAttribute("produits", produitService.getAllProduits());
        return "produits/list-produits";
    }

}