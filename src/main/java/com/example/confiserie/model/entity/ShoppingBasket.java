package com.example.confiserie.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class ShoppingBasket extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @ManyToOne
    private User buyer;


    private BigDecimal totalSum;
    @OneToMany(mappedBy = "shoppingBasket")
    private Set<Item> items = new HashSet<>();

    public ShoppingBasket() {
    }

    public Order getOrder() {
        return order;
    }

    public ShoppingBasket setOrder(Order order) {
        this.order = order;
        return this;
    }

    public User getBuyer() {
        return buyer;
    }

    public ShoppingBasket setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public ShoppingBasket setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
        return this;
    }

    public Set<Item> getItems() {
        return items;
    }

    public ShoppingBasket setItems(Set<Item> items) {
        this.items = items;
        return this;
    }
}
