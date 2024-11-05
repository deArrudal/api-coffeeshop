package com.example.api_coffeeshop.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_coffeeshop.item.Item;
import com.example.api_coffeeshop.item.ItemService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/createItem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping(value = "/readItem/{customerOrderId}/{coffeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item readItem(@PathVariable("customerOrderId") Long customerOrderId, @PathVariable("coffeeId") Long coffeeId) {
        return itemService.readItem(customerOrderId, coffeeId);
    }

    @PutMapping(value = "/updateItem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @DeleteMapping(value = "/deleteItem/{customerOrderId}/{coffeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item deleteItem(@PathVariable("customerOrderId") Long customerOrderId, @PathVariable("coffeeId") Long coffeeId) {
        return itemService.deleteItem(customerOrderId, coffeeId);
    }

    @GetMapping(value = "/readAllItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> readAllItem() {
        return itemService.readAllItem();
    }
}
