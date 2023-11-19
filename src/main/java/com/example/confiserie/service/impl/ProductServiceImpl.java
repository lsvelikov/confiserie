package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.ProductAddDto;
import com.example.confiserie.model.entity.Category;
import com.example.confiserie.model.entity.Product;
import com.example.confiserie.model.dtos.PictureViewDto;
import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.repository.ProductRepository;
import com.example.confiserie.service.CategoryService;
import com.example.confiserie.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Category category = categoryService.findByCategoryNameEnum(productAddDto.getCategory());

        if (category != null) {
            product.setCategory(category);
        }
        productRepository.save(product);
    }

    @Override
    public List<ProductViewDto> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(product -> {
                    ProductViewDto productViewDto = mapper.map(product, ProductViewDto.class);
                    List<PictureViewDto> pictures = product
                            .getPictures()
                            .stream()
                            .map(picture -> mapper.map(picture, PictureViewDto.class))
                            .collect(Collectors.toList());

                    productViewDto.setPictureViewDtoList(pictures);
                    return productViewDto;
                }).collect(Collectors.toList());
    }
}
