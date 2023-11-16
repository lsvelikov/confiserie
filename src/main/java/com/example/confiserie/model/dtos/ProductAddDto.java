package com.example.confiserie.model.dtos;

import com.example.confiserie.model.enums.CategoryEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductAddDto {

    @NotNull(message = "Please enter product")
    @Size(min = 3, max = 20, message = "Product length must be between 3 and 20 characters")
    private String name;
    @NotNull
    @Size(min = 5, max = 300, message = "Description length must be between 5 and 300 characters")
    private String description;
    @NotNull(message = "Price cannot be empty")
    @Positive(message = "Price must be positive number")
    private Double price;
    @NotNull(message = "Select category")
    private CategoryEnum category;
    private String imageUrl;
    @Positive(message = "Quantity should be 0 or more")
    private int quantity;


    public ProductAddDto() {
    }

    public String getName() {
        return name;
    }

    public ProductAddDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductAddDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ProductAddDto setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductAddDto setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductAddDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
