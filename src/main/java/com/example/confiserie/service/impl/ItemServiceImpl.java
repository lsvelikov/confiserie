package com.example.confiserie.service.impl;

import com.example.confiserie.model.entity.Item;
import com.example.confiserie.repository.ItemRepository;
import com.example.confiserie.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void save(Item newItem) {
        itemRepository.save(newItem);
    }

    @Override
    public Item findByProductAndShoppingBasket(Long product_id, Long shoppingBasket_id) {
        return itemRepository.findItemByProduct_IdAndShoppingBasket_Id(product_id, shoppingBasket_id)
                .orElse(null);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }
}
