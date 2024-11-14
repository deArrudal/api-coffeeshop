package com.example.api_coffeeshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_coffeeshop.model.Item;
import com.example.api_coffeeshop.service.ItemService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
POST /items: Create a item.
GET /items: Get all items.
GET /items/{id}: Get a item by its ID.
PUT /items/{id}: Update a item by its ID.
DELETE /items/{id}: Delete a item by its ID.
 */

@CrossOrigin("http://localhost:4200")
 @RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody @Valid Item item) {
        Item savedItem = itemService.createItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/{customerOrderId}/{coffeeId}")
    public ResponseEntity<Item> readItem(@PathVariable("customerOrderId") Long customerOrderId,
            @PathVariable("coffeeId") Long coffeeId) {
        Item readItem = itemService.readItem(customerOrderId, coffeeId);
        return new ResponseEntity<>(readItem, HttpStatus.OK);
    }

    @PutMapping("/{customerOrderId}/{coffeeId}")
    public ResponseEntity<Item> updateItem(@PathVariable("customerOrderId") Long customerOrderId,
            @PathVariable("coffeeId") Long coffeeId, @RequestBody @Valid Item item) {
        Item updatedItem = itemService.updateItem(customerOrderId, coffeeId, item);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{customerOrderId}/{coffeeId}")
    public ResponseEntity<Void> deleteItem(@PathVariable("customerOrderId") Long customerOrderId,
            @PathVariable("coffeeId") Long coffeeId) {
        itemService.deleteItem(customerOrderId, coffeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Item>> readAllItem() {
        List<Item> items = itemService.readAllItem();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
