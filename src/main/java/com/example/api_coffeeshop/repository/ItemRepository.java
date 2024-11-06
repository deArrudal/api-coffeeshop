package com.example.api_coffeeshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_coffeeshop.model.Item;
import com.example.api_coffeeshop.model.ItemId;

@Repository
public interface ItemRepository extends JpaRepository<Item, ItemId> {
    List<Item> findByCustomerOrderId(Long customerOrderId);

    List<Item> findByCoffeeId(Long coffeeId);

}