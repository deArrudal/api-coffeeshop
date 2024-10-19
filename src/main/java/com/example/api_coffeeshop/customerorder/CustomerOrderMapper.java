package com.example.api_coffeeshop.customerorder;

import org.mapstruct.Mapper;

import com.example.api_coffeeshop.item.ItemMapper;

@Mapper(uses = ItemMapper.class)
public interface CustomerOrderMapper {
    CustomerOrderDTO customerOrderToCustomerOrderDTO(CustomerOrder customerOrder);
    CustomerOrder customerOrderDTOToCustomerOrder(CustomerOrderDTO customerOrderDTO);
}