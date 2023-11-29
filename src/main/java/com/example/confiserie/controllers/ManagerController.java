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
@RequestMapping("/managers")
public class ManagerController {

    private final UserService userService;

    public ManagerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String allManagers(Model model) {

        List<UserViewDto> allManagers = userService.findAllManagers();
        model.addAttribute("allManagers", allManagers);

        return "manager";
    }

    @GetMapping("/make-admin/{id}")
    public String makeAdmin(@PathVariable Long id) {

        userService.makeAdmin(id);

        return "redirect:/admin";
    }

    @GetMapping("/delete-manager/{id}")
    public String deleteManager(@PathVariable Long id) {

        userService.deleteManager(id);

        return "redirect:/users/all";
    }
}
