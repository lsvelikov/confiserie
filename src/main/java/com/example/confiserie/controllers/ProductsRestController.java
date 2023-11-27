package com.example.confiserie.controllers;

import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductsRestController {

    private final ProductService productService;

    public ProductsRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductViewDto>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductViewDto> findById(@PathVariable("id") Long id) {
        ProductViewDto product = productService.findById(id);

        return ResponseEntity.ok(product);
    }
}
