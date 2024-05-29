package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.repository.ItemRepository;
import com.example.confiserie.repository.ProductRepository;
import com.example.confiserie.repository.ShoppingBasketRepository;
import com.example.confiserie.service.OrderService;
import com.example.confiserie.service.ShoppingBasketService;
import com.example.confiserie.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {

    private final ShoppingBasketRepository shoppingBasketRepository;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final OrderService orderService;

    private final ItemRepository itemRepository;

    public ShoppingBasketServiceImpl(ShoppingBasketRepository shoppingBasketRepository, ProductRepository productRepository, UserService userService, OrderService orderService, ItemRepository itemRepository) {
        this.shoppingBasketRepository = shoppingBasketRepository;
        this.productRepository = productRepository;
        this.userService = userService;
        this.orderService = orderService;
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public void buy(Long id, UserDetails buyer, ProductViewDto productViewDto) {

    }
}
