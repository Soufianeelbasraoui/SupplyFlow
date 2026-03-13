package org.example.supplyflow.controller;

import org.example.supplyflow.model.MouvementStock;
import org.example.supplyflow.model.Produit;
import org.example.supplyflow.service.MouvementStockService;
import org.example.supplyflow.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/mouvements")
public class MouvementStockController {
    private MouvementStockService mouvementStockService;
    private ProduitService produitService;

    public MouvementStockController(MouvementStockService mouvementStockService, ProduitService produitService) {
        this.mouvementStockService = mouvementStockService;
        this.produitService = produitService;
    }

    @GetMapping
    public String listMouvementStck(Model model){
        model.addAttribute("mouvements",mouvementStockService.getAllStock());
        return "mouvements/list-mouvements";
    }

    @GetMapping("/new")
    public String addMouvement(Model model){
        model.addAttribute("mouvement",new MouvementStock());
        model.addAttribute("produits",produitService.getAllProduits());
        return "mouvements/add-mouvement";

    }
    @PostMapping("/save")
    public String saveMouvements(@ModelAttribute MouvementStock mouvementStock, @RequestParam ("id_produit") int idproduit,@RequestParam int quantite,@RequestParam String type){
        mouvementStockService.saveMouvementStck(idproduit,quantite,type);
        return "redirect:/mouvements";
    }
}
