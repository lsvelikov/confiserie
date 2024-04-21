package com.example.confiserie.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 512)
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column
    private String imageUrl;
    @Column
    private Integer quantity;
    @ManyToOne
    private Category category;
    @ManyToOne
    @JoinColumn(name = "shopping_basket_id", referencedColumnName = "id")
    private ShoppingBasket shoppingBasket;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Item setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Item setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Item setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Item setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Item setCategory(Category category) {
        this.category = category;
        return this;
    }

    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    public Item setShoppingBasket(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
        return this;
    }
}
