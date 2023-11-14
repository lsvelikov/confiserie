package com.example.confiserie.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 512)
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(name = "number_orders")
    private int numberOrders;
    @Column
    private String imageUrl;

    @OneToOne
    private Category category;
    @ManyToMany
    private Set<User> usersLikes;

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

    public int getNumberOrders() {
        return numberOrders;
    }

    public Product setNumberOrders(int numberOrders) {
        this.numberOrders = numberOrders;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Product setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Set<User> getUsersLikes() {
        return usersLikes;
    }

    public Product setUsersLikes(Set<User> usersLikes) {
        this.usersLikes = usersLikes;
        return this;
    }
}
