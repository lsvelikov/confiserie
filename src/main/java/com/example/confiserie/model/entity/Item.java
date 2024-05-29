package com.example.confiserie.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column
    private String imageUrl;
    @Column
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

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


    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    public Item setShoppingBasket(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Item setProduct(Product product) {
        this.product = product;
        return this;
    }
}
