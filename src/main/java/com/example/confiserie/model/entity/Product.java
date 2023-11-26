package com.example.confiserie.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 512)
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column
    private String imageUrl;
    @Column
    private Integer quantity;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Order order;
    public Product() {
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Product setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public Product setOrder(Order order) {
        this.order = order;
        return this;
    }
}
