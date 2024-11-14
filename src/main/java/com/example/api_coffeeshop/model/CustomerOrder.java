package com.example.api_coffeeshop.model;

import java.io.Serializable;
import java.util.List;

import com.example.api_coffeeshop.dto.ItemDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_order")
public class CustomerOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    @Column(nullable = false)
    private String customerName;

    @Transient
    private List<ItemDTO> items;

    @Transient
    private double total;

    public void setTotal() {
        total = items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getCoffeePrice())
                .sum();
    }
}
