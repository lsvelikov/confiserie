package com.example.confiserie.repository;

import com.example.confiserie.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findItemByProduct_IdAndShoppingBasket_Id(Long product_id, Long shoppingBasket_id);
}
