package com.example.confiserie.model.dtos;

public class ProductViewDto {

    private Long id;
    private String name;
    private Double price;
    private String imageUrl;
    private Integer quantity;

    private String imgUrl;

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

    public Integer getQuantity() {
        return quantity;
    }

    public ProductViewDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ProductViewDto setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
