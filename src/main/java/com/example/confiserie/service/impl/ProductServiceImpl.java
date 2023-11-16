package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.ProductAddDto;
import com.example.confiserie.model.entity.Product;
import com.example.confiserie.repository.ProductRepository;
import com.example.confiserie.service.CategoryService;
import com.example.confiserie.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @Override
    public void addProduct(ProductAddDto productAddDto) {
        Product product = mapper.map(productAddDto, Product.class);
        product.setCategory(categoryService.findByCategoryNameEnum(productAddDto.getCategory()));

        productRepository.save(product);
    }
}
