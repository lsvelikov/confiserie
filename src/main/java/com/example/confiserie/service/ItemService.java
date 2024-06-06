package com.example.confiserie.service;

import com.example.confiserie.model.entity.Item;

public interface ItemService {

    void save(Item item);

    Item findByProductAndShoppingBasket(Long product_id, Long shoppingBasket_id);

}
