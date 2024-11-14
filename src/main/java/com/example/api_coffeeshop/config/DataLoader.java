package com.example.api_coffeeshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.api_coffeeshop.model.Coffee;
import com.example.api_coffeeshop.repository.CoffeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CoffeeRepository coffeeRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Create coffees
        String[][] coffees = {
                { "Espresso", "2.00" },
                { "Americano", "2.50" },
                { "Latte", "3.50" },
                { "Cappuccino", "3.50" },
                { "Flat White", "4.00" },
                { "Mocha", "4.50" },
                { "Macchiato", "3.00" },
                { "Cold Brew", "4.00" },
                { "Iced Latte", "4.00" },
                { "Nitro Cold Brew", "5.00" }
        };

        for (String[] coffee : coffees) {
            saveCoffee(coffee);
        }
    }

    private void saveCoffee(String[] coffee) {
        String name = coffee[0];
        double price = Double.parseDouble(coffee[1]);

        if (!coffeeRepository.existsByName(name)) {
            Coffee newCoffee = new Coffee();
            newCoffee.setName(name);
            newCoffee.setPrice(price);

            coffeeRepository.save(newCoffee);
        }
    }
}
