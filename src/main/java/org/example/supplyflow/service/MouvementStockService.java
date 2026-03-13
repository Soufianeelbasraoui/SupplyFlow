package org.example.supplyflow.service;

import org.example.supplyflow.model.MouvementStock;
import org.example.supplyflow.model.Produit;
import org.example.supplyflow.repository.MouvementStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MouvementStockService {
    @Autowired
    private MouvementStockRepository mouvementStockRepository;
    @Autowired
    private  ProduitService produitService;

    public MouvementStockService(MouvementStockRepository mouvementStockRepository) {
        this.mouvementStockRepository = mouvementStockRepository;
    }
    public List<MouvementStock> getAllStock(){
        return mouvementStockRepository.findAll();
    }
    public void saveMouvementStck(int idproduit, int quantite, String type){
        Produit produit=produitService.getProduitByID(idproduit);
        if(type.equals("ENTREE")){
            produit.setQuantite(produit.getQuantite()+quantite);
        } else if (type.equals("SORTIE")) {
            produit.setQuantite(produit.getQuantite()-quantite);
        }
        MouvementStock mouvementStock=new MouvementStock();
        mouvementStock.setProduit(produit);
        mouvementStock.setQuantite(quantite);
        mouvementStock.setDate(LocalDateTime.now());
        mouvementStock.setType(type);
        mouvementStockRepository.save(mouvementStock);
        produitService.saveProduit(produit);
    }
}
