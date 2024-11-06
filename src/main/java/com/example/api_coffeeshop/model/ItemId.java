package com.example.api_coffeeshop.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ItemId implements Serializable {
    private Long customerOrderId;
    private Long coffeeId;
}