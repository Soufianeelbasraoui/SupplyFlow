package org.example.supplyflow.repository;

import org.example.supplyflow.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository <Fournisseur , Indexed> {
}
