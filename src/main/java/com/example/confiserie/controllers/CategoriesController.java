package com.example.confiserie.controllers;

import com.example.confiserie.model.dtos.CategoryViewDto;
import com.example.confiserie.model.enums.CategoryEnum;
import com.example.confiserie.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/assortment")
public class CategoriesController {

    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String assortment() {
        return "assortment";
    }


    @GetMapping("/jam")
    public String getJams(Model model) {
        List<CategoryViewDto> allCategories = categoryService.findAll();
        CategoryViewDto categoryViewDto = categoryService.findByNameJam(CategoryEnum.JAM);

        model.addAttribute("allCategories", allCategories);
        model.addAttribute("allJams", categoryViewDto.getProducts());
        return "categories";
    }

    @GetMapping("/truffle")
    public String getTruffles(Model model) {
        List<CategoryViewDto> allCategories = categoryService.findAll();
        CategoryViewDto categoryViewDto = categoryService.findByNameTruffle(CategoryEnum.TRUFFLE);

        model.addAttribute("allCategories", allCategories);
        model.addAttribute("allTruffles", categoryViewDto.getProducts());
        return "categories";
    }

    @GetMapping("/cake")
    public String getCakes(Model model) {
        List<CategoryViewDto> allCategories = categoryService.findAll();
        CategoryViewDto categoryViewDto = categoryService.findByNameCake(CategoryEnum.CAKE);

        model.addAttribute("allCategories", allCategories);
        model.addAttribute("allCakes", categoryViewDto.getProducts());
        return "categories";
    }

    @GetMapping("/tart")
    public String getTarts(Model model) {
        List<CategoryViewDto> allCategories = categoryService.findAll();
        CategoryViewDto categoryViewDto = categoryService.findByNameTart(CategoryEnum.TART);

        model.addAttribute("allCategories", allCategories);
        model.addAttribute("allTarts", categoryViewDto.getProducts());
        return "categories";
    }

    @GetMapping("/macarons")
    public String getMacarons(Model model) {
        List<CategoryViewDto> allCategories = categoryService.findAll();
        CategoryViewDto categoryViewDto = categoryService.findByNameMacarons(CategoryEnum.MACARONS);

        model.addAttribute("allCategories", allCategories);
        model.addAttribute("allMacarons", categoryViewDto.getProducts());
        return "categories";
    }
}
