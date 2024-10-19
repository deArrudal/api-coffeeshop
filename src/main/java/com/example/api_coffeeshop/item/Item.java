package com.example.api_coffeeshop.item;

import java.io.Serializable;

import org.hibernate.annotations.ColumnDefault;

import com.example.api_coffeeshop.coffee.Coffee;
import com.example.api_coffeeshop.customerorder.CustomerOrder;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item implements Serializable {
    @EmbeddedId
    private ItemId id;

    @ManyToOne
    @MapsId("customerOrderId")
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @ManyToOne
    @MapsId("coffeeId")
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

    @ColumnDefault("1")
    private Double quantity;
}
