package com.example.confiserie.controllers;

import com.example.confiserie.model.serviceModel.ProductServiceModel;
import com.example.confiserie.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String add() {
        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(Model model,
                             @ModelAttribute("productServiceModel") @Valid ProductServiceModel productServiceModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productServiceModel", productServiceModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productServiceModel", bindingResult);

            return "redirect:add";
        }

        this.productService.addProduct(productServiceModel);
        return "redirect:/";
    }
    @ModelAttribute
    public ProductServiceModel productServiceModel(){
        return new ProductServiceModel();
    }



    @GetMapping("/all")
    public String all() {
        return "products-all";
    }

}
