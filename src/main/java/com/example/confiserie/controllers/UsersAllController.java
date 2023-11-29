package com.example.confiserie.controllers;

import com.example.confiserie.model.dtos.UserViewDto;
import com.example.confiserie.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersAllController {

    private final UserService userService;

    public UsersAllController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/categories")
    public String users() {
        return "users-categories";
    }

    @GetMapping("/all")
    public String usersList(Model model) {

        List<UserViewDto> allUsers = userService.findAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "users-all";
    }

    @GetMapping("/make-admin/{id}")
    public String makeAdmin(@PathVariable Long id) {

        userService.makeAdmin(id);

        return "redirect:/admin";
    }

    @GetMapping("/make-manager/{id}")
    public String makeManager(@PathVariable Long id) {

        userService.makeManager(id);

        return "redirect:/managers/all";
    }
}
