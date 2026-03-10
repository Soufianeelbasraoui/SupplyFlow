package org.example.supplyflow.repository;

import org.example.supplyflow.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementStockRepository extends JpaRepository <MouvementStock, Integer> {
}
