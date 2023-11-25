package com.example.confiserie.model.dtos;

public class ProductViewDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
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

    public Double getPrice() {
        return price;
    }

    public ProductViewDto setPrice(Double price) {
        this.price = price;
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
