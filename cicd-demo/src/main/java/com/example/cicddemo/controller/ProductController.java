package com.example.cicddemo.controller;

import com.example.cicddemo.entity.Product;
import com.example.cicddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String home() {
        return "<h1>Welcome to the home page</h1>";
    }

    @GetMapping("/products")
    public CollectionModel<EntityModel<Product>> all() {
        return productService.all();
    }

    @PostMapping("/products")
    public ResponseEntity<?> newProduct(@RequestBody Product newProduct) {
        return productService.newProduct(newProduct);
    }

    @GetMapping("/products/{id}")
    public EntityModel<Product> one(@PathVariable Long id) {
        return productService.one(id);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) throws URISyntaxException {
        return productService.replaceProduct(newProduct, id);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
