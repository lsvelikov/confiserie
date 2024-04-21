package com.example.confiserie.model.serviceModel;

import com.example.confiserie.model.enums.CategoryEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class ProductServiceModel {
    private Long id;

    @NotNull(message = "Please enter product")
    @Size(min = 3, max = 20, message = "Product length must be between 3 and 20 characters")
    private String name;
    @NotNull
    @Size(min = 5, max = 300, message = "Description length must be between 5 and 300 characters")
    private String description;
    @NotNull(message = "Price cannot be empty")
    @Positive(message = "Price must be positive number")
    private Double price;
    @PositiveOrZero(message = "Quantity must be positive number or null")
    private int quantity;
    @NotNull(message = "Select category")
    private CategoryEnum category;

    private MultipartFile img;




    public ProductServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(Double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductServiceModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public MultipartFile getImg() {
        return img;
    }

    public ProductServiceModel setImg(MultipartFile img) {
        this.img = img;
        return this;
    }



}
