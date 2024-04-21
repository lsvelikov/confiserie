package com.example.confiserie.service;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.model.entity.Item;

public interface ItemService {
    Item createItem(ProductViewDto productViewDto);

    Item findItem(Long id);

    void save(Item newItem);
}
