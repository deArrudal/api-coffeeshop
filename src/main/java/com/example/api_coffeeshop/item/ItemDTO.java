package com.example.api_coffeeshop.item;

import lombok.Data;

@Data
public class ItemDTO {
    private String coffeeName;
    private Double coffeePrice;
    private Double quantity;
}