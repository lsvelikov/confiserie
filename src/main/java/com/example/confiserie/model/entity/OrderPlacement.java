package com.example.confiserie.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_placement")
public class OrderPlacement extends BaseEntity {

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
    @Column(name = "order_status", nullable = false)
    private String orderStatus;
    @Column(name = "receipt_date", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime receiptDate;
    @Column(name = "shipping_date", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime shippingDate;
    @ManyToOne
    private User buyer;

    public OrderPlacement() {
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderPlacement setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public OrderPlacement setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public LocalDateTime getReceiptDate() {
        return receiptDate;
    }

    public OrderPlacement setReceiptDate(LocalDateTime receiptDate) {
        this.receiptDate = receiptDate;
        return this;
    }

    public LocalDateTime getShippingDate() {
        return shippingDate;
    }

    public OrderPlacement setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public User getBuyer() {
        return buyer;
    }

    public OrderPlacement setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }
}
