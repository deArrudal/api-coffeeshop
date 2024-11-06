package com.example.api_coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_coffeeshop.exception.CoffeeNotFoundException;
import com.example.api_coffeeshop.exception.CustomerOrderNotFoundException;
import com.example.api_coffeeshop.exception.ItemNotFoundException;
import com.example.api_coffeeshop.model.Coffee;
import com.example.api_coffeeshop.model.CustomerOrder;
import com.example.api_coffeeshop.model.Item;
import com.example.api_coffeeshop.model.ItemId;
import com.example.api_coffeeshop.repository.CoffeeRepository;
import com.example.api_coffeeshop.repository.CustomerOrderRepository;
import com.example.api_coffeeshop.repository.ItemRepository;

// TODO: create functions to add/remove x quantities from item
@Service
public class ItemService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private ItemRepository itemRepository;

    // TODO: fix to prevent existing items from being updated 
    public Item createItem(Item item) {
        CustomerOrder customerOrder = customerOrderRepository.findById(item.getCustomerOrder().getId())
                .orElseThrow(() -> new CustomerOrderNotFoundException(item.getCustomerOrder().getId()));
        Coffee coffee = coffeeRepository.findById(item.getCoffee().getId())
                .orElseThrow(() -> new CoffeeNotFoundException(item.getCoffee().getId()));
        ItemId itemId = new ItemId(customerOrder.getId(), coffee.getId());
        item.setId(itemId);
        item.setCustomerOrder(customerOrder);
        item.setCoffee(coffee);
        return itemRepository.save(item);
    }

    public Item readItem(Long customerOrderId, Long coffeeId) {
        ItemId itemId = new ItemId(customerOrderId, coffeeId);
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    public Item updateItem(Long customerOrderId, Long coffeeId, Item item) {
        CustomerOrder customerOrder = customerOrderRepository.findById(customerOrderId)
                .orElseThrow(() -> new CustomerOrderNotFoundException(customerOrderId));
        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new CoffeeNotFoundException(coffeeId));
        ItemId itemId = new ItemId(customerOrderId, coffeeId);
        if (!itemRepository.findById(itemId).isPresent()) {
            throw new ItemNotFoundException(itemId);
        }
        item.setId(itemId);
        item.setCustomerOrder(customerOrder);
        item.setCoffee(coffee);
        return itemRepository.save(item);
    }

    public void deleteItem(Long customerOrderId, Long coffeeId) {
        ItemId itemId = new ItemId(customerOrderId, coffeeId);
        if (!itemRepository.findById(itemId).isPresent()) {
            throw new ItemNotFoundException(itemId);
        }
        itemRepository.deleteById(itemId);
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
