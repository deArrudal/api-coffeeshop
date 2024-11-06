package com.example.api_coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api_coffeeshop.model.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    @Procedure(procedureName = "computeTotalByCustomerOrderId")
    Double computeTotalByCustomerOrderId(@Param("customerOrderId") Long customerOrderId);
}
