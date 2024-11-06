package com.example.api_coffeeshop.exception;

public class CustomerOrderNotFoundException extends RuntimeException {
    public CustomerOrderNotFoundException(Long id) {
        super("Customer Order with id " + id + " not found");
    }
}
