package com.example.confiserie.model.entity;

import com.example.confiserie.model.enums.OrderPaymentMethodEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payment_method")
public class OrderPaymentMethod extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private OrderPaymentMethodEnum name;

    @OneToMany
    private List<Order> order;

    public OrderPaymentMethod() {
    }

    public OrderPaymentMethodEnum getName() {
        return name;
    }

    public OrderPaymentMethod setName(OrderPaymentMethodEnum name) {
        this.name = name;
        return this;
    }

    public List<Order> getOrder() {
        return order;
    }

    public OrderPaymentMethod setOrder(List<Order> order) {
        this.order = order;
        return this;
    }
}
