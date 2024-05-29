package com.example.confiserie.model.dtos;

import com.example.confiserie.model.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderViewDto {

    private Long id;
    private List<ShoppingBasketViewDto> basketViewDtoList = new ArrayList<>();

    private BigDecimal total;

    private User buyer;

    public OrderViewDto() {
    }

    public Long getId() {
        return id;
    }

    public OrderViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public List<ShoppingBasketViewDto> getBasketViewDtoList() {
        return basketViewDtoList;
    }

    public OrderViewDto setBasketViewDtoList(List<ShoppingBasketViewDto> basketViewDtoList) {
        this.basketViewDtoList = basketViewDtoList;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public OrderViewDto setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public User getBuyer() {
        return buyer;
    }

    public OrderViewDto setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }
}
