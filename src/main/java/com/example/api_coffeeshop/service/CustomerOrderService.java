package com.example.api_coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api_coffeeshop.exception.CustomerOrderNotFoundException;
import com.example.api_coffeeshop.model.CustomerOrder;
import com.example.api_coffeeshop.repository.CustomerOrderRepository;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private ItemService itemService;

    public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    @Transactional
    public CustomerOrder readCustomerOrder(Long id) {
        CustomerOrder readCustomerOrder = customerOrderRepository.findById(id)
                .orElseThrow(() -> new CustomerOrderNotFoundException(id));
        readCustomerOrder.setItems(itemService.readAllItemByCustomerOrderId(id));
        readCustomerOrder.setTotal();
        return readCustomerOrder;
    }

    public CustomerOrder updateCustomerOrder(Long id, CustomerOrder customerOrder) {
        if (!customerOrderRepository.findById(id).isPresent()) {
            throw new CustomerOrderNotFoundException(id);
        }
        customerOrder.setId(id);
        return customerOrderRepository.save(customerOrder);
    }

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
