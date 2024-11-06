package com.example.api_coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_coffeeshop.model.Coffee;
import com.example.api_coffeeshop.model.CustomerOrder;
import com.example.api_coffeeshop.model.Item;
import com.example.api_coffeeshop.model.ItemId;
import com.example.api_coffeeshop.repository.CoffeeRepository;
import com.example.api_coffeeshop.repository.CustomerOrderRepository;
import com.example.api_coffeeshop.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        CustomerOrder customerOrder = customerOrderRepository.findById(item.getCustomerOrder().getId()).orElseThrow();
        Coffee coffee = coffeeRepository.findById(item.getCoffee().getId()).orElseThrow();
        ItemId itemId = new ItemId();
        itemId.setCustomerOrderId(customerOrder.getId());
        itemId.setCoffeeId(coffee.getId());
        Item newItem = new Item();
        newItem.setId(itemId);
        newItem.setCustomerOrder(customerOrder);
        newItem.setCoffee(coffee);
        newItem.setQuantity(item.getQuantity());
        return itemRepository.save(newItem);
    }

    public Item readItem(Long customerOrderId, Long coffeeId) {
        ItemId itemId = new ItemId();
        itemId.setCustomerOrderId(customerOrderId);
        itemId.setCoffeeId(coffeeId);
        return itemRepository.findById(itemId).orElseThrow();
    }

    public Item updateItem(Item item) {
        ItemId itemId = new ItemId();
        itemId.setCustomerOrderId(item.getCustomerOrder().getId());
        itemId.setCoffeeId(item.getCoffee().getId());
        Item newItem = itemRepository.findById(itemId).orElseThrow();
        newItem.setQuantity(item.getQuantity());
        return itemRepository.save(newItem);
    }

    public Item deleteItem(Long customerOrderId, Long coffeeId) {
        ItemId itemId = new ItemId();
        itemId.setCustomerOrderId(customerOrderId);
        itemId.setCoffeeId(coffeeId);
        Item newItem = itemRepository.findById(itemId).orElseThrow();
        itemRepository.delete(newItem);
        return newItem;
    }

    public List<Item> readAllItem() {
        return itemRepository.findAll();
    }

    public void deleteAllItemByCustomerOrderId(Long customerOrderId) {
        List<Item> items = itemRepository.findByCustomerOrderId(customerOrderId);
        itemRepository.deleteAll(items);
    }

    public void deleteAllItemByCoffeeId(Long coffeeId) {
        List<Item> items = itemRepository.findByCoffeeId(coffeeId);
        itemRepository.deleteAll(items);
    }
}
