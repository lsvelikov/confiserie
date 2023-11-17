package com.example.confiserie.init;

import com.example.confiserie.service.CategoryService;
import com.example.confiserie.service.OrderPaymentService;
import com.example.confiserie.service.RoleService;
import com.example.confiserie.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConfiInit implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final OrderPaymentService orderPaymentService;
    private final RoleService roleService;

    public ConfiInit(CategoryService categoryService, UserService userService, OrderPaymentService orderPaymentService, RoleService roleService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.orderPaymentService = orderPaymentService;
        this.roleService = roleService;
    }


    @Override
    public void run(String... args) throws Exception {
        categoryService.categoryInit();
        roleService.initRoles();
        userService.initUser();
        orderPaymentService.orderPaymentMethodInit();

    }
}
