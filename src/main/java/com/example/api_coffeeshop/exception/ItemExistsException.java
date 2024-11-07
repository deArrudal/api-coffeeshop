package com.example.api_coffeeshop.exception;

import com.example.api_coffeeshop.model.ItemId;

public class ItemExistsException extends RuntimeException {
        public ItemExistsException(ItemId itemId) {
        super("Item with id " + itemId.toString() + " already exists");
    }
}
