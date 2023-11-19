package com.example.confiserie.service;

import com.example.confiserie.model.dtos.ProductAddDto;
import com.example.confiserie.model.dtos.ProductViewDto;

import java.util.List;

public interface ProductService {
    void addProduct(ProductAddDto productAddDto);

    List<ProductViewDto> findAll();
}
