package com.example.confiserie.service;

import com.example.confiserie.model.dtos.OrderViewDto;
import com.example.confiserie.model.entity.Order;

import java.util.List;

public interface OrderService {

    Order findByUser(Long id);

    void save(Order order);

    List<OrderViewDto> findAll();


}
