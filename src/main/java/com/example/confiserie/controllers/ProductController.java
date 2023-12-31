package com.example.confiserie.controllers;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.model.entity.Product;
import com.example.confiserie.model.serviceModel.ProductServiceModel;
import com.example.confiserie.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

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
        return "redirect:add";
    }

    @GetMapping("/all")
    public String all(Model model) {

        List<ProductViewDto> products = productService.findAll();
        model.addAttribute("products", products);

        return "products";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteProduct(id);

        return "redirect:/products/all";
    }

    @GetMapping("/change-product/{id}")
    public String change(@PathVariable Long id, Model model) {

        model.addAttribute("product", productService.findById(id));

        return "product-update";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String update(@PathVariable Long id, @ModelAttribute("product") ProductViewDto productViewDto) {

        Product existingProduct = productService.findProduct(id);
        existingProduct.setId(productViewDto.getId());
        existingProduct.setDescription(productViewDto.getDescription());
        existingProduct.setPrice(productViewDto.getPrice());
        productService.saveUpdate(existingProduct);

        return "redirect:/products/all";

    }

    @ModelAttribute
    public ProductServiceModel productServiceModel(){
        return new ProductServiceModel();
    }

}
