package com.example.confiserie.model.dtos;

import com.example.confiserie.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OrderViewDto {

    private Long id;
    private List<ProductViewDto> products = new ArrayList<>();

    private Double price;

    private User buyer;

    public OrderViewDto() {
    }

//    public OrderViewDto(List<ProductViewDto> products) {
//        this.products = new ArrayList<>();
//    }

    public Long getId() {
        return id;
    }

    public OrderViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public List<ProductViewDto> getProducts() {
        return products;
    }

    public OrderViewDto setProducts(List<ProductViewDto> products) {
        this.products = products;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public OrderViewDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public User getBuyer() {
        return buyer;
    }

    public OrderViewDto setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }
}
