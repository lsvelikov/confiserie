package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.service.ShoppingBasketService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    @Override
    public void buy(Long id, UserDetails buyer, ProductViewDto productViewDto) {

    }
}
