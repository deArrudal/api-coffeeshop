package com.example.api_coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api_coffeeshop.model.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    @Query("SELECT SUM(i.quantity * c.price) FROM Item i JOIN i.coffee c WHERE i.customerOrder.id = :customerOrderId")
    Double computeTotalByCustomerOrderId(@Param("customerOrderId") Long customerOrderId);
}
