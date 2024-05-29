package com.example.confiserie.service;

import com.example.confiserie.model.dtos.OrderViewDto;
import com.example.confiserie.model.entity.Order;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface OrderService {

    Order findByUser(Long id);

    void save(Order order);

    List<OrderViewDto> findAll();


    List<OrderViewDto> findAllOpenOrdersByUser(UserDetails currentUser);
}
