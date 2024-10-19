package com.example.api_coffeeshop.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, ItemId> {
    List<Item> findByCustomerOrderId(Long customerOrderId);

    List<Item> findByCoffeeId(Long coffeeId);

}
