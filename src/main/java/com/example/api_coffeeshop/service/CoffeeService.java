package com.example.api_coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_coffeeshop.model.Coffee;
import com.example.api_coffeeshop.repository.CoffeeRepository;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private ItemService itemService;

    public Coffee createCoffee(Coffee coffee) {
        Coffee newCoffee = new Coffee();
        newCoffee.setName(coffee.getName());
        newCoffee.setPrice(coffee.getPrice());
        return coffeeRepository.save(newCoffee);
    }

    public Coffee readCoffee(Long id) {
        return coffeeRepository.findById(id).orElseThrow();
    }

    public Coffee updateCoffee(Coffee coffee) {
        Coffee newCoffee = coffeeRepository.findById(coffee.getId()).orElseThrow();
        newCoffee.setName(coffee.getName());
        newCoffee.setPrice(coffee.getPrice());
        return coffeeRepository.save(newCoffee);
    }

    public Coffee deleteCoffee(Long id) {
        Coffee newCoffee = coffeeRepository.findById(id).orElseThrow();
        // Find all items associated with this coffee and remove
        itemService.deleteAllItemByCoffeeId(id);;
        coffeeRepository.delete(newCoffee);
        return newCoffee;
    }

    public List<Coffee> readAllCoffee() {
        return coffeeRepository.findAll();
    }
}
