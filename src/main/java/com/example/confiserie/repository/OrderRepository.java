package com.example.confiserie.repository;

import com.example.confiserie.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o " +
            "WHERE o.buyer.id = :id AND o.isPlaced = false")
    Order findByBuyer(Long id);

    @Query("SELECT o FROM Order o " +
            "WHERE o.buyer.email = :email")
    Order findByUserEmail(String email);

    @Query("SELECT o FROM Order o " +
            "WHERE o.buyer.id = :id AND o.isPlaced = false")
    List<Order> findAllOpenOrdersByUser(Long id);
    @Query("SELECT o FROM Order o " +
           "WHERE o.buyer.id = :id AND o.isPlaced = true")
    List<Order> findAllPlacedOrdersByUser(Long id);
}
