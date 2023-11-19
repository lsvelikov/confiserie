package com.example.confiserie.model.dtos;

public class PictureViewDto {

    private Long id;
    private String title;
    private String imgUrl;

    public PictureViewDto() {
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public PictureViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public PictureViewDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public PictureViewDto setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
