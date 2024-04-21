package com.example.confiserie.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_basket")
public class ShoppingBasket extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @ManyToOne
    private User buyer;
    @Column(name = "total_sum")
    private Double totalSum;
    @OneToMany(mappedBy = "shoppingBasket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Double getTotalSum() {
        return totalSum;
    }

    public ShoppingBasket setTotalSum(Double totalSum) {
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
