package com.example.confiserie.model.dtos;

import com.example.confiserie.model.enums.CategoryEnum;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewDto {

    private CategoryEnum name;
    private List<ProductViewDto> products;

    public CategoryViewDto() {
    }

    public CategoryViewDto(List<ProductViewDto> products) {
        this.products = new ArrayList<>();
    }

    public CategoryEnum getName() {
        return name;
    }

    public CategoryViewDto setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public List<ProductViewDto> getProducts() {
        return products;
    }

    public CategoryViewDto setProducts(List<ProductViewDto> products) {
        this.products = products;
        return this;
    }
}
