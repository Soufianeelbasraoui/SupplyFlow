package org.example.supplyflow.service;

import org.example.supplyflow.model.Produit;
import org.example.supplyflow.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll()         ;
    }

    public void saveProduit(Produit produit) {
        produitRepository.save(produit);
    }

    public void deleteProduit(int id) {
        produitRepository.deleteById(id);
    }

    public Produit getProduitByID(int id) {
        return produitRepository.findById(id).orElse(null);
    }
}