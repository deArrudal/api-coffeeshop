package com.example.api_coffeeshop.exception;

public class CoffeeNotFoundException extends RuntimeException {
    public CoffeeNotFoundException(Long id) {
        super("Coffee with id " + id + " not found");
    }
}
