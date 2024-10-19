package com.example.api_coffeeshop.item;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ItemMapper {
    @Mappings({
            @Mapping(source = "coffee.name", target = "coffeeName"),
            @Mapping(source = "coffee.price", target = "coffeePrice") })
    ItemDTO itemToItemDTO(Item item);

/*     @Mappings({
            @Mapping(target = "customerOrder", expression = "java(findCustomerOrder(itemDTO))"),
            @Mapping(target = "coffee", expression = "java(findCoffee(itemDTO))") }) */
    Item itemDTOToItem(ItemDTO itemDTO);

/*     default CustomerOrder findCustomerOrder(ItemDTO itemDTO) {
        // Logic to retrieve Coffee based on itemDTO.coffeeName
    }

    default Coffee findCoffee(ItemDTO itemDTO) {
        // Logic to retrieve Coffee based on itemDTO.coffeeName
    } */
}
