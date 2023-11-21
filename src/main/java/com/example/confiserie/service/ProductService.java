package com.example.confiserie.service;

import com.example.confiserie.model.serviceModel.ProductServiceModel;

import java.io.IOException;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel) throws IOException;

//    List<ProductViewDto> findAll();
}
