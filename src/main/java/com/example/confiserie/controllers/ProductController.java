package com.example.confiserie.controllers;

import com.example.confiserie.model.dtos.ProductAddDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {


    @GetMapping("/add")
    public String add() {
        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid ProductAddDto productAddDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddDto", productAddDto)
                    .addFlashAttribute("org.springframework.BindingResult.productAddDto", bindingResult);
            return "redirect:add";
        }
        return "redirect:/";
    }

    @ModelAttribute
    public ProductAddDto productAddDto() {
        return new ProductAddDto();
    }
}
