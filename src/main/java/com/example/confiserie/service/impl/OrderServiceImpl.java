package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.ItemViewDto;
import com.example.confiserie.model.dtos.OrderViewDto;
import com.example.confiserie.model.dtos.ShoppingBasketViewDto;
import com.example.confiserie.model.entity.Order;
import com.example.confiserie.model.entity.User;
import com.example.confiserie.repository.OrderRepository;
import com.example.confiserie.service.OrderService;
import com.example.confiserie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public List<OrderViewDto> findAllOpenOrdersByUser(UserDetails currentUser) {
        User current = userService.findByEmail(currentUser.getUsername());

        List<OrderViewDto> allOpen = orderRepository.findAllOpenOrdersByUser(current.getId())
                .stream()
                .map(order -> {
                    OrderViewDto orderViewDto = mapper.map(order, OrderViewDto.class);
                    List<ShoppingBasketViewDto> basketViewDtoList = order.getShoppingBaskets()
                            .stream()
                            .map(shoppingBasket -> {
                                ShoppingBasketViewDto shoppingBasketViewDto = mapper.map(shoppingBasket, ShoppingBasketViewDto.class);
                                List<ItemViewDto> itemViewDtoList = shoppingBasket.getItems()
                                        .stream()
                                        .map(item -> {
                                            ItemViewDto itemViewDto = mapper.map(item, ItemViewDto.class);
                                            itemViewDto.setName(item.getName());
                                            return itemViewDto;
                                        }).collect(Collectors.toList());

                                shoppingBasketViewDto.setItemsList(itemViewDtoList);
                                return  shoppingBasketViewDto;
                            }).collect(Collectors.toList());

                    BigDecimal total = order.getShoppingBaskets()
                            .stream()
                            .map(shoppingBasket -> shoppingBasket.getTotalSum())
                            .reduce(BigDecimal::add)
                            .orElse(BigDecimal.ZERO);
                    orderViewDto.setTotal(total);

                    orderViewDto.setBasketViewDtoList(basketViewDtoList);
                    return orderViewDto;
                }).collect(Collectors.toList());

        return allOpen;
    }


}
