package com.example.confiserie.model.dtos;

import java.math.BigDecimal;

public class ProductViewDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String imageUrl;

    public ProductViewDto() {
    }

    public Long getId() {
        return id;
    }

    public ProductViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductViewDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductViewDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductViewDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
