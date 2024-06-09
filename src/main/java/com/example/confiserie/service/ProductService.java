package com.example.confiserie.service;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.model.entity.Product;
import com.example.confiserie.model.serviceModel.ProductServiceModel;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel) throws IOException;

    List<ProductViewDto> findAll();

    void deleteProduct(Long id);

    ProductViewDto findById(Long id);

    void updateProduct(ProductViewDto productToUpdate);

    Product findProduct(Long id);

    void saveUpdate(Product existingProduct);

}
