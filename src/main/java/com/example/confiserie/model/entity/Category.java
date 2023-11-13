package com.example.confiserie.model.entity;

import com.example.confiserie.model.enums.CategoryEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @OneToMany
    private List<Product> products;

    public Category() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Category setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
