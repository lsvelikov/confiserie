package com.example.confiserie.repository;

import com.example.confiserie.model.entity.OrderPlacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPlacementRepository extends JpaRepository<OrderPlacement, Long> {

}
