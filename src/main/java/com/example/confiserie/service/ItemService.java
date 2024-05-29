package com.example.confiserie.service;

import com.example.confiserie.model.entity.Item;

public interface ItemService {
//    Item createItem(ProductViewDto productViewDto);

//    Item findItem(Long id);

    void save(Item item);

    Item findByProductAndShoppingBasket(Long product_id, Long shoppingBasket_id);
}
