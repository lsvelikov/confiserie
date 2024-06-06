package com.example.confiserie.service;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.model.entity.ShoppingBasket;
import org.springframework.security.core.userdetails.UserDetails;

public interface ShoppingBasketService {

    void save(ShoppingBasket shoppingBasket);

    void buy(Long id, UserDetails buyer, ProductViewDto productViewDto);

}
