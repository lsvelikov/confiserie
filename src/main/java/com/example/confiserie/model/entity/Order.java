package com.example.confiserie.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "created_time", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdTime;
    @Column
    private Double price;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @ManyToOne
    private OrderPaymentMethod paymentMethod;
    @Column(name = "delivered_time", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime deliveredTime;
    @ManyToOne
    private User buyer;

    public Order() {
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public Order setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Order setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Order setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public OrderPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Order setPaymentMethod(OrderPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public LocalDateTime getDeliveredTime() {
        return deliveredTime;
    }

    public Order setDeliveredTime(LocalDateTime deliveredTime) {
        this.deliveredTime = deliveredTime;
        return this;
    }

    public User getBuyer() {
        return buyer;
    }

    public Order setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }
}
