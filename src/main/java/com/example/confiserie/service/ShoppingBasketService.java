package com.example.confiserie.service;

import com.example.confiserie.model.dtos.ProductViewDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface ShoppingBasketService {

    void buy(Long id, UserDetails buyer, ProductViewDto productViewDto);
}
