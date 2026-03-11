package org.example.supplyflow.service;

import org.example.supplyflow.model.Fournisseur;
import org.example.supplyflow.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> findAllFournisseur() {
        return fournisseurRepository.findAll();}

//    public ArrayList<Fournisseur> findAllFournisseur(){
//        return (ArrayList<Fournisseur>)fournisseurRepository.findAll();
//
//    }
    public void AjouterFournisseur(Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
    }
    public void deletFournisseur(int id){
        fournisseurRepository.deleteById(id);
    }

}
