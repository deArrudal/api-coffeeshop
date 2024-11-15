package com.example.api_coffeeshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_coffeeshop.model.CustomerOrder;
import com.example.api_coffeeshop.service.CustomerOrderService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
POST /customerOrders: Create a customer order.
GET /customerOrders: Get all customer orders.
GET /customerOrders/{id}: Get a customer order by its ID.
PUT /customerOrders/{id}: Update a customer order by its ID.
DELETE /customerOrders/{id}: Delete a customer Order by its ID.
 */

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/customerOrders")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping
    public ResponseEntity<CustomerOrder> createCustomerOrder(@RequestBody @Valid CustomerOrder customerOrder) {
        CustomerOrder savedCustomerOrder = customerOrderService.createCustomerOrder(customerOrder);
        return new ResponseEntity<>(savedCustomerOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> readCustomerOrder(@PathVariable("id") Long id) {
        CustomerOrder readCustomerOrder = customerOrderService.readCustomerOrder(id);
        return new ResponseEntity<>(readCustomerOrder, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerOrder> updateCustomerOrder(@PathVariable("id") Long id,
            @RequestBody @Valid CustomerOrder customerOrder) {
        CustomerOrder updatedCustomerOrder = customerOrderService.updateCustomerOrder(id, customerOrder);
        return new ResponseEntity<>(updatedCustomerOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerOrder(@PathVariable("id") Long id) {
        customerOrderService.deleteCustomerOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<CustomerOrder>> readAllCustomerOrder() {
        List<CustomerOrder> customerOrders = customerOrderService.readAllCustomerOrder();
        return new ResponseEntity<>(customerOrders, HttpStatus.OK);
    }
}
