package com.example.confiserie.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column
    private Double totalPrice;
    @ManyToOne
    private OrderPaymentMethod paymentMethod;
    private boolean isPlaced;
    @ManyToOne
    private User buyer;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ShoppingBasket> shoppingBaskets = new ArrayList<>();

    public Order() {
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public OrderPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Order setPaymentMethod(OrderPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public Order setPlaced(boolean placed) {
        isPlaced = placed;
        return this;
    }

    public User getBuyer() {
        return buyer;
    }

    public Order setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }

    public List<ShoppingBasket> getShoppingBaskets() {
        return shoppingBaskets;
    }

    public Order setShoppingBaskets(List<ShoppingBasket> shoppingBaskets) {
        this.shoppingBaskets = shoppingBaskets;
        return this;
    }
}
