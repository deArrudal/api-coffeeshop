package com.example.api_coffeeshop.coffee;

import lombok.Data;

@Data
public class CoffeeDTO {
    private long id;
    private String name;
    private Double price;
}
