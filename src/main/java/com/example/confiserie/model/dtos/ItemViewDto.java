package com.example.confiserie.model.dtos;

import java.math.BigDecimal;

public class ItemViewDto {

    private Long id;

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemViewDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    private String imageUrl;

    private String name;

    private BigDecimal totalPrice;

    private Integer quantity;

    public ItemViewDto() {
    }

    public Long getId() {
        return id;
    }

    public ItemViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public ItemViewDto setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ItemViewDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
