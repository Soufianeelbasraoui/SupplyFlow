package org.example.supplyflow.service;

import org.example.supplyflow.model.Produit;
import org.example.supplyflow.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll()         ;
    }

    public void saveProduit(Produit produit) {
        produitRepository.save(produit);
    }


    public Produit getProduitByID(int id) {
        return produitRepository.findById(id).orElse(null);
    }

public void deleteProduitById(int id) {
    Produit produit = produitRepository.findById(id).orElse(null);
    if(produit != null){
        produit.getMouvementStocks().clear();
        produitRepository.delete(produit);
    }
}
}