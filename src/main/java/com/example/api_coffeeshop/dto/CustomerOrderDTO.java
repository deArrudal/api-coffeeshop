package com.example.api_coffeeshop.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerOrderDTO {
    private String customerName;
    private List<ItemDTO> items;
    private Double total;
}
