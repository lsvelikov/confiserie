package com.example.confiserie.repository;

import com.example.confiserie.model.entity.ShoppingBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {

    Optional<ShoppingBasket> findShoppingBasketByOrder_IdAndBuyer_Id(Long order_id, Long buyer_id);
    @Query("SELECT b FROM ShoppingBasket b " +
           "WHERE b.order.id = :id")
    Optional<ShoppingBasket> findByOrder(Long id);
}
