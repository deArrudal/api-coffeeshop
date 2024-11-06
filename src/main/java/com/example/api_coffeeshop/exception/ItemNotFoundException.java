package com.example.api_coffeeshop.exception;

import com.example.api_coffeeshop.model.ItemId;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(ItemId itemId) {
        super("Item with id " + itemId.toString() + " not found");
    }
}
