package com.example.confiserie.service;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.model.serviceModel.ProductServiceModel;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel) throws IOException;

    List<ProductViewDto> findAll();

    void deleteProduct(Long id);
}
