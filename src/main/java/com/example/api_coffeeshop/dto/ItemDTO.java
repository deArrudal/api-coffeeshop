package com.example.api_coffeeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {
    private String coffeeName;
    private Double coffeePrice;
    private Double quantity;
}
