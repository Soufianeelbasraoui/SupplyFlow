package org.example.supplyflow.controller;

import org.example.supplyflow.model.Fournisseur;
import org.example.supplyflow.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

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
 @GetMapping("/edit/{id}")
 public String editFournisseut(@PathVariable("id") int id,Model model){
      Fournisseur fournisseur=fournisseurService.findById(id);
      model.addAttribute("fournisseur" ,fournisseur);
     return "fournisseurs/edit-fournisseur";
 }
 @GetMapping("/delete/{id}")
    public String deletFournisseurs(@PathVariable("id")int id){
        fournisseurService.deletFournisseur(id);
        return "redirect:/fournisseurs";

 }

}
