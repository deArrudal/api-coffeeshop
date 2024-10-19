package com.example.api_coffeeshop.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_coffeeshop.customerorder.CustomerOrder;
import com.example.api_coffeeshop.customerorder.CustomerOrderService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/customerOrder")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping(value = "/createCustomerOrder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerOrder createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.createCustomerOrder(customerOrder);
    }

    @GetMapping(value = "/readCustomerOrder/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerOrder readCustomerOrder(@PathVariable("id") Long id) {
        return customerOrderService.readCustomerOrder(id);
    }

    @PutMapping(value = "/updateCustomerOrder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerOrder updateCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.updateCustomerOrder(customerOrder);
    }

    @DeleteMapping(value = "/deleteCustomerOrder/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerOrder deleteCustomerOrder(@PathVariable("id") Long id) {
        return customerOrderService.deleteCustomerOrder(id);
    }

    @GetMapping(value = "/readAllCustomerOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerOrder> readAllCustomerOrder() {
        return customerOrderService.readAllCustomerOrder();
    }
}
