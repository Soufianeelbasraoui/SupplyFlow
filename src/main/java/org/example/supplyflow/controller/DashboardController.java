package org.example.supplyflow.controller;

import org.example.supplyflow.service.FournisseurService;
import org.example.supplyflow.service.ProduitService;
import org.example.supplyflow.model.Produit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private ProduitService produitService;
    private FournisseurService fournisseurService;

    public DashboardController(ProduitService produitService, FournisseurService fournisseurService) {
        this.produitService = produitService;
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("/")
    public String dashboard(Model model){
        List<Produit> produits = produitService.getAllProduits();

        model.addAttribute("produits", produits);
        model.addAttribute("fournisseurs", fournisseurService.findAllFournisseur());

        model.addAttribute("totalProduits", produits.size());
        model.addAttribute("totalFournisseurs", fournisseurService.findAllFournisseur().size());

        int totalStock = produits.stream().mapToInt(Produit::getQuantite).sum();
        model.addAttribute("totalStock", totalStock);

        return "index";
    }
}