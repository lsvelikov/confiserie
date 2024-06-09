package com.example.confiserie.service;

import com.example.confiserie.model.entity.Item;

import java.util.Optional;

public interface ItemService {

    void save(Item item);

    Item findByProductAndShoppingBasket(Long product_id, Long shoppingBasket_id);

    Optional<Item> findById(Long id);

    void delete(Item item);
}
