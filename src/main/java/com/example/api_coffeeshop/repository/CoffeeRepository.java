package com.example.api_coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_coffeeshop.model.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    boolean existsByName(String name);
}
