package com.example.confiserie.controllers;

import com.example.confiserie.model.dtos.OrderViewDto;
import com.example.confiserie.service.OrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserOrdersController {

    private final OrderService orderService;

    public UserOrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String allOrders(Model model,
                            @AuthenticationPrincipal UserDetails currentUser) {

        List<OrderViewDto> allOpenOrders = orderService.findAllOpenOrdersByUser(currentUser);
        model.addAttribute("allOpenOrders", allOpenOrders);

        return "orders";
    }

}
