package com.example.api_coffeeshop.coffee;

import org.mapstruct.Mapper;

@Mapper
public interface CoffeeMapper {
    CoffeeDTO coffeeToCoffeeDTO(Coffee coffee);
    Coffee coffeeDTOToCoffee(CoffeeDTO coffeeDTO);
}
