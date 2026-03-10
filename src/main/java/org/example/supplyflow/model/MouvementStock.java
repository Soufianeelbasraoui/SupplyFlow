package org.example.supplyflow.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mouvementStock")
public class MouvementStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantite",nullable = false)
    private int quantite;
    @Column(name = "type",nullable = false)
    private String type;
    @Column(name = "date" ,nullable = false)
    private LocalDateTime date;

    public MouvementStock(){}
    @ManyToOne
    @JoinColumn(name = "id_produit",nullable = false)
    private Produit produit;


    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
