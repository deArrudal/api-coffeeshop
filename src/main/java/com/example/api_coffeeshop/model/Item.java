package com.example.api_coffeeshop.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item implements Serializable {
    @EmbeddedId
    private ItemId id;

    @NotNull(message = "Customer Order cannot be null")
    @ManyToOne
    @MapsId("customerOrderId")
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @NotNull(message = "Coffee cannot be null")
    @ManyToOne
    @MapsId("coffeeId")
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be positive")
    private Double quantity;
}
