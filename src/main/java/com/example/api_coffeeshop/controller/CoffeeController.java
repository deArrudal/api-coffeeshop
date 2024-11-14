package com.example.api_coffeeshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_coffeeshop.model.Coffee;
import com.example.api_coffeeshop.service.CoffeeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
POST /coffees: Create a coffee.
GET /coffees: Get all coffees.
GET /coffees/{id}: Get a coffee by its ID.
PUT /coffees/{id}: Update a coffee by its ID.
DELETE /coffees/{id}: Delete a coffee by its ID.
 */

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping
    public ResponseEntity<Coffee> createCoffee(@RequestBody @Valid Coffee coffee) {
        Coffee savedCoffee = coffeeService.createCoffee(coffee);
        return new ResponseEntity<>(savedCoffee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> readCoffee(@PathVariable("id") Long id) {
        Coffee readCoffee = coffeeService.readCoffee(id);
        return new ResponseEntity<>(readCoffee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable("id") Long id, @RequestBody @Valid Coffee coffee) {
        Coffee updatedCoffee = coffeeService.updateCoffee(id, coffee);
        return new ResponseEntity<>(updatedCoffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable("id") Long id) {
        coffeeService.deleteCoffee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Coffee>> readAllCoffee() {
        List<Coffee> coffees = coffeeService.readAllCoffee();
        return new ResponseEntity<>(coffees, HttpStatus.OK);
    }
}
