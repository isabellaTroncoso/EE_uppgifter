package com.example.demo_3.controller;

import com.example.demo_3.model.Product;
import com.example.demo_3.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        logger.info("Creating product: {}", product.getName());
        Product saved = service.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("Fetching all products");
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/search")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        logger.info("Searching for product with name: {}", name);
        Product product = service.findByName(name);
        logger.info("Found product: {}", product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/test-error")
    public void testError() {
        logger.warn("testError endpoint called - about to throw RuntimeException");
        throw new RuntimeException("This is a test error");
    }

}
