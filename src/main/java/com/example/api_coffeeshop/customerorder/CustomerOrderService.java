package com.example.api_coffeeshop.customerorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_coffeeshop.item.ItemService;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private ItemService itemService;

    public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
        CustomerOrder newCustomerOrder = new CustomerOrder();
        newCustomerOrder.setCustomerName(customerOrder.getCustomerName());
        return customerOrderRepository.save(newCustomerOrder);
    }

    public CustomerOrder readCustomerOrder(Long id) {
        return customerOrderRepository.findById(id).orElseThrow();
    }

    public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder) {
        CustomerOrder newCustomerOrder = customerOrderRepository.findById(customerOrder.getId()).orElseThrow();
        newCustomerOrder.setCustomerName(customerOrder.getCustomerName());
        return customerOrderRepository.save(newCustomerOrder);
    }

    public CustomerOrder deleteCustomerOrder(Long id) {
        CustomerOrder newCustomerOrder = customerOrderRepository.findById(id).orElseThrow();
        itemService.deleteAllItemByCustomerOrderId(id);
        customerOrderRepository.delete(newCustomerOrder);
        return newCustomerOrder;
    }

    public List<CustomerOrder> readAllCustomerOrder() {
        return customerOrderRepository.findAll();
    }
}
