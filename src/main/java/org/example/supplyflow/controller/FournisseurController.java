package org.example.supplyflow.controller;

import org.example.supplyflow.model.Fournisseur;
import org.example.supplyflow.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {

    private FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public String listFournisseur(Model model){
     model.addAttribute("fournisseurs",fournisseurService.findAllFournisseur());
     return "Fournisseurs/Liste-Fournisseurs";
 }
   @GetMapping ("/new")
    public String addFournisseur(Model model){
        model.addAttribute("fournisseur",new Fournisseur());
        return "Fournisseurs/add-fournisseur";

 }
 @PostMapping("/save")
 public String saveFournisseur(@ModelAttribute  Fournisseur fournisseur){
        fournisseurService.AjouterFournisseur(fournisseur);
        return "redirect:/fournisseurs";
 }

}
