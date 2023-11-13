package com.example.confiserie.init;

import com.example.confiserie.service.CategoryService;
import com.example.confiserie.service.OrderPaymentService;
import com.example.confiserie.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConfiInit implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final OrderPaymentService orderPaymentService;

    public ConfiInit(CategoryService categoryService, UserService userService, OrderPaymentService orderPaymentService) {
        this.categoryService = categoryService;
        this.userService = userService;

        this.orderPaymentService = orderPaymentService;
    }


    @Override
    public void run(String... args) throws Exception {
        categoryService.categoryInit();
        userService.initUser();
        orderPaymentService.orderPaymentMethodInit();
    }
}
