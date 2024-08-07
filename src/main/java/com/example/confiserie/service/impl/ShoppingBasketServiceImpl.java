package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.model.entity.*;
import com.example.confiserie.repository.ShoppingBasketRepository;
import com.example.confiserie.service.*;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {

    private final ShoppingBasketRepository shoppingBasketRepository;
    private final ProductService productService;
    private final UserService userService;
    private final OrderService orderService;

    private final ItemService itemService;

    public ShoppingBasketServiceImpl(ShoppingBasketRepository shoppingBasketRepository, ProductService productService, UserService userService, OrderService orderService, ItemService itemService) {
        this.shoppingBasketRepository = shoppingBasketRepository;
        this.productService = productService;
        this.userService = userService;
        this.orderService = orderService;
        this.itemService = itemService;
    }

    @Override
    public void save(ShoppingBasket shoppingBasket) {
        shoppingBasketRepository.save(shoppingBasket);
    }

    @Override
    @Transactional
    public void buy(Long id, UserDetails buyer, ProductViewDto productViewDto) {
        Product product = productService.findProduct(id);

        User userBuyer = userService.findByEmail(buyer.getUsername());

        Order order = orderService.findByUser(userBuyer.getId());

        Integer quantity = productViewDto.getQuantity();

        if (order == null) {
            order = new Order();
            order.setBuyer(userBuyer);
            orderService.save(order);
        }

        List<ShoppingBasket> shoppingBasketList = order.getShoppingBaskets();

        ShoppingBasket shoppingBasket = shoppingBasketRepository.
                findShoppingBasketByOrder_IdAndBuyer_Id(order.getId(), userBuyer.getId())
                .orElse(null);

        if (shoppingBasket == null) {
            shoppingBasket = new ShoppingBasket();
            shoppingBasket.setOrder(order);
            shoppingBasket.setBuyer(userBuyer);
            shoppingBasketList.add(shoppingBasket);
            shoppingBasketRepository.save(shoppingBasket);
        }

        Set<Item> items = shoppingBasket.getItems();

        Item item = itemService.findByProductAndShoppingBasket(product.getId(), shoppingBasket.getId());

        if (item == null) {
            item = new Item();
            item.setProduct(product);
            item.setName(product.getName());
            item.setQuantity(0);
            if (product.getQuantity() >= quantity + item.getQuantity()) {
                item.setQuantity(quantity);
                BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
                item.setTotalPrice(totalPrice);
                item.setShoppingBasket(shoppingBasket);
            } else {
                throw new IllegalArgumentException("Not enough pieces im stock");
            }
        } else {
            if (product.getQuantity() >= quantity + item.getQuantity()) {
                item.setTotalPrice(item.getTotalPrice().add(product.getPrice().multiply(BigDecimal.valueOf(quantity))));
                Integer totalQuantity = item.getQuantity() + quantity;
                item.setQuantity(totalQuantity);
            } else {
                throw new IllegalArgumentException("Not enough pieces im stock");
            }
        }

        itemService.save(item);

        items.add(item);

        shoppingBasket.setItems(items);

        BigDecimal totalSum = shoppingBasket
                .getItems()
                .stream()
                .map(Item::getTotalPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        shoppingBasket.setTotalSum(totalSum);

        shoppingBasketRepository.save(shoppingBasket);

        order.setShoppingBaskets(shoppingBasketList);

        BigDecimal total = order
                .getShoppingBaskets()
                .stream()
                .map(ShoppingBasket::getTotalSum)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        order.setTotalPrice(total);

        orderService.save(order);
    }

}
