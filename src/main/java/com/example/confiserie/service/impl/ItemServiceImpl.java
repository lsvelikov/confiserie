package com.example.confiserie.service.impl;

import com.example.confiserie.model.entity.Item;
import com.example.confiserie.repository.ItemRepository;
import com.example.confiserie.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper mapper;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper mapper) {
        this.itemRepository = itemRepository;
        this.mapper = mapper;
    }

//    @Override
//    public Item createItem(ProductViewDto productViewDto) {
//        Item item = new Item();
//        mapper.map(productViewDto, CreateItemDto.class);
//        CreateItemDto createItemDto = new CreateItemDto();
//        mapper.map(createItemDto, Item.class);
//        itemRepository.save(item);
//        return item;
//    }

//    @Override
//    public Item findItem(Long id) {
//        return itemRepository.findById(id)
//                .orElseThrow(() -> new ObjectNotFoundException("Item not found"));
//    }

    @Override
    public void save(Item newItem) {
        itemRepository.save(newItem);
    }

    @Override
    public Item findByProductAndShoppingBasket(Long product_id, Long shoppingBasket_id) {
        return itemRepository.findItemByProduct_IdAndShoppingBasket_Id(product_id, shoppingBasket_id)
                .orElse(null);
    }

//    @Override
//    public Optional<Item> findById(Long id) {
//        return itemRepository.findById(id);
//    }

//    @Override
//    public void delete(Item item) {
//        itemRepository.delete(item);
//    }
}
