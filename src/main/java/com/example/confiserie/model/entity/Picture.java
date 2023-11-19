package com.example.confiserie.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pitures")
public class Picture extends BaseEntity {
    @Column
    private String title;
    @Column(nullable = false)
    private String imageUrl;
    @ManyToOne
    private Product product;

    public Picture() {
    }

    public String getTitle() {
        return title;
    }

    public Picture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Picture setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Picture setProduct(Product product) {
        this.product = product;
        return this;
    }
}
