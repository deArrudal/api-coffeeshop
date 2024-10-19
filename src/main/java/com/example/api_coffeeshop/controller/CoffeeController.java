package com.example.api_coffeeshop.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_coffeeshop.coffee.Coffee;
import com.example.api_coffeeshop.coffee.CoffeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping(value = "/createCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return coffeeService.createCoffee(coffee);
    }

    @GetMapping(value = "/readCoffee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee readCoffee(@PathVariable Long id) {
        return coffeeService.readCoffee(id);
    }

    @PutMapping(value = "/updateCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee updateCoffee(@RequestBody Coffee coffee) {
        return coffeeService.updateCoffee(coffee);
    }

    @DeleteMapping(value = "/deleteCoffee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee deleteCoffee(@PathVariable Long id) {
        return coffeeService.deleteCoffee(id);
    }

    @GetMapping(value = "/readAllCoffee", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coffee> readAllCoffee() {
        return coffeeService.readAllCoffee();
    }
}
