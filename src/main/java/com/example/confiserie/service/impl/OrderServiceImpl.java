package com.example.confiserie.service.impl;

import com.example.confiserie.exeption.ObjectNotFoundException;
import com.example.confiserie.model.dtos.ItemViewDto;
import com.example.confiserie.model.dtos.OrderViewDto;
import com.example.confiserie.model.dtos.ShoppingBasketViewDto;
import com.example.confiserie.model.entity.*;
import com.example.confiserie.repository.OrderRepository;
import com.example.confiserie.repository.ProductRepository;
import com.example.confiserie.repository.ShoppingBasketRepository;
import com.example.confiserie.service.ItemService;
import com.example.confiserie.service.OrderService;
import com.example.confiserie.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper mapper;
    private final UserService userService;

    private final ItemService itemService;

    private final ShoppingBasketRepository shoppingBasketRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper mapper, UserService userService, ItemService itemService, ShoppingBasketRepository shoppingBasketRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.userService = userService;
        this.itemService = itemService;
        this.shoppingBasketRepository = shoppingBasketRepository;
        this.productRepository = productRepository;
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

                                shoppingBasketViewDto.setItemList(itemViewDtoList);
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

    @Override
    public List<OrderViewDto> findAllPlacedOrdersByUser(UserDetails currentUser) {
        User current = userService.findByEmail(currentUser.getUsername());

        List<OrderViewDto> placedOrders = orderRepository.findAllPlacedOrdersByUser(current.getId())
                .stream()
                .map(order -> {
                    OrderViewDto orderViewDto = mapper.map(order, OrderViewDto.class);
                    List<ShoppingBasketViewDto> shoppingBasketViewDtoList = order.getShoppingBaskets()
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

                                shoppingBasketViewDto.setItemList(itemViewDtoList);
                                return shoppingBasketViewDto;
                            }).collect(Collectors.toList());

                    BigDecimal total = order.getShoppingBaskets()
                            .stream()
                            .map(shoppingBasket -> shoppingBasket.getTotalSum())
                            .reduce(BigDecimal::add)
                            .orElse(BigDecimal.ZERO);

                    orderViewDto.setTotal(total);

                    orderViewDto.setBasketViewDtoList(shoppingBasketViewDtoList);
                    return orderViewDto;
                }).collect(Collectors.toList());

        return placedOrders;
    }

    @Override
    @Transactional
    public void delete(Long id, UserDetails buyer) {
        User userBuyer = userService.findByEmail(buyer.getUsername());
        Order order = orderRepository.findByBuyer(userBuyer.getId());
        Item toDelete = itemService.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Product not found"));

        if (order != null && !order.isPlaced()) {
            ShoppingBasket shoppingBasket = shoppingBasketRepository.findByOrder(order.getId()).orElse(null);
            toDelete.setShoppingBasket(null);

            assert shoppingBasket != null;
            shoppingBasket.getItems().remove(toDelete);
            itemService.delete(toDelete);
            BigDecimal totalSum = shoppingBasket
                    .getItems()
                    .stream()
                    .map(Item::getTotalPrice)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);
            shoppingBasket.setTotalSum(totalSum);

            shoppingBasketRepository.save(shoppingBasket);

            order.setTotalPrice(totalSum);

            orderRepository.save(order);
        }
    }

    @Override
    public void placeOrder(Long id, UserDetails buyer) {
        User userBuyer = userService.findByEmail(buyer.getUsername());
        Order order = orderRepository.findByBuyer(userBuyer.getId());
        ShoppingBasket shoppingBasket = shoppingBasketRepository.findByOrder(order.getId()).orElse(null);

        assert shoppingBasket != null;
        Set<Item> ordered = shoppingBasket.getItems();

        for (Item item : ordered) {
            Product product = productRepository.findById(item.getProduct().getId()).get();
            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepository.save(product);
        }

        order.setPlaced(true);
        orderRepository.save(order);
    }

    @Override
    public Order findByBuyer(Long id) {
        return orderRepository.findByBuyer(id);
    }
}
