package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.OrderViewDto;
import com.example.confiserie.model.entity.Order;
import com.example.confiserie.repository.OrderRepository;
import com.example.confiserie.service.OrderService;
import com.example.confiserie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper mapper;
    private final UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper mapper, UserService userService) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public Order findByUser(Long id) {
        return orderRepository.findByBuyer(id);
    }

    @Override
    public void save(Order order) {
          orderRepository.save(order);
    }

    @Override
    public List<OrderViewDto> findAll() {
        return orderRepository
                .findAll()
                .stream()
                .map(order -> mapper.map(order, OrderViewDto.class))
                .collect(Collectors.toList());
    }


}
