package com.example.api_coffeeshop.customerorder;

import java.util.List;

import com.example.api_coffeeshop.item.ItemDTO;

import lombok.Data;

@Data
public class CustomerOrderDTO {
    private Long id;
    private String customerName;
    private List<ItemDTO> items;
    private Double total;
}
