package com.example.confiserie.controllers;

import com.example.confiserie.model.dtos.UserViewDto;
import com.example.confiserie.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String adminPage(Model model) {

        List<UserViewDto> allAdmins = userService.findAllAdmins();
        model.addAttribute("allAdmins", allAdmins);

        return "admin";
    }

    @GetMapping("/categories")
    public String allCategoriesUsers() {
        return "users-categories";
    }
}
