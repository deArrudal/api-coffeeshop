package com.example.api_coffeeshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_coffeeshop.dto.CustomerOrderDTO;
import com.example.api_coffeeshop.dto.ItemDTO;
import com.example.api_coffeeshop.exception.CustomerOrderNotFoundException;
import com.example.api_coffeeshop.model.CustomerOrder;
import com.example.api_coffeeshop.repository.CustomerOrderRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private ItemService itemService;

    @Transactional
    public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    @Transactional
    public CustomerOrderDTO readCustomerOrder(Long id) {
        CustomerOrder readCustomerOrder = customerOrderRepository.findById(id)
                .orElseThrow(() -> new CustomerOrderNotFoundException(id));
        return getCustomerDTO(readCustomerOrder);
    }

    private CustomerOrderDTO getCustomerDTO(CustomerOrder customerOrder) {
        List<Object[]> items = customerOrderRepository.findItemByCustomerOrder(customerOrder.getId());
        List<ItemDTO> itemsDTO = items.stream()
                .map(row -> new ItemDTO(
                        (String) row[0],
                        (Double) row[1],
                        (Double) row[2]))
                .collect(Collectors.toList());
        Double total = itemsDTO.stream()
                .mapToDouble(item -> item.getQuantity() * item.getCoffeePrice())
                .sum();
        return new CustomerOrderDTO(customerOrder.getCustomerName(), itemsDTO, total);
    }

    @Transactional
    public CustomerOrder updateCustomerOrder(Long id, CustomerOrder customerOrder) {
        if (!customerOrderRepository.findById(id).isPresent()) {
            throw new CustomerOrderNotFoundException(id);
        }
        customerOrder.setId(id);
        return customerOrderRepository.save(customerOrder);
    }

    @Transactional
    public void deleteCustomerOrder(Long id) {
        if (!customerOrderRepository.findById(id).isPresent()) {
            throw new CustomerOrderNotFoundException(id);
        }
        // Find all items associated with this customer order and remove
        itemService.deleteAllItemByCustomerOrderId(id);
        customerOrderRepository.deleteById(id);
    }

    public List<CustomerOrder> readAllCustomerOrder() {
        return customerOrderRepository.findAll();
    }
}
