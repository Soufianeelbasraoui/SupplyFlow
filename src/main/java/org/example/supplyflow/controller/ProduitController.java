package org.example.supplyflow.controller;

import org.example.supplyflow.model.Produit;
import org.example.supplyflow.service.FournisseurService;
import org.example.supplyflow.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    private ProduitService produitService;
    private FournisseurService fournisseurService;


    public ProduitController(ProduitService produitService, FournisseurService fournisseurService) {
        this.produitService = produitService;
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public String listProduits(Model model) {
        model.addAttribute("produits", produitService.getAllProduits());
        return "produits/list-produits";
    }

    @GetMapping("/new")
    public String addProduct(Model model) {
        model.addAttribute("produit", new Produit());
        model.addAttribute("fournisseurs", fournisseurService.findAllFournisseur());
        return "produits/add-produit";
    }

    @PostMapping("/save")
    public String saveProduit(@ModelAttribute Produit produit, @RequestParam("id_fournisseur") int idFournisseur) {
        produit.setFournisseur(fournisseurService.findById(idFournisseur));
        produitService.saveProduit(produit);
        return "redirect:/produits";
    }
}


