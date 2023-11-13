package com.example.confiserie.repository;

import com.example.confiserie.model.entity.OrderPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPaymentMethodRepository extends JpaRepository<OrderPaymentMethod, Long> {
}
