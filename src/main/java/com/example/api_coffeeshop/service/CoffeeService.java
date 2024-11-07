package com.example.api_coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_coffeeshop.exception.CoffeeNotFoundException;
import com.example.api_coffeeshop.model.Coffee;
import com.example.api_coffeeshop.repository.CoffeeRepository;

import jakarta.transaction.Transactional;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private ItemService itemService;

    @Transactional
    public Coffee createCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public Coffee readCoffee(Long id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new CoffeeNotFoundException(id));
    }

    @Transactional
    public Coffee updateCoffee(Long id, Coffee coffee) {
        if (!coffeeRepository.findById(id).isPresent()) {
            throw new CoffeeNotFoundException(id);
        }
        coffee.setId(id);
        return coffeeRepository.save(coffee);
    }

    @Transactional
    public void deleteCoffee(Long id) {
        if (!coffeeRepository.findById(id).isPresent()) {
            throw new CoffeeNotFoundException(id);
        }
        // Find all items associated with this coffee and remove
        itemService.deleteAllItemByCoffeeId(id);
        coffeeRepository.deleteById(id);
    }

    public List<Coffee> readAllCoffee() {
        return coffeeRepository.findAll();
    }
}
