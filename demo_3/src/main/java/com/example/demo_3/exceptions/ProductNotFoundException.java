package com.example.demo_3.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String name) {
        super("Product not found: " + name);
    }
}
