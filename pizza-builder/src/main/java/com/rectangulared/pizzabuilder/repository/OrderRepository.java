package com.rectangulared.pizzabuilder.repository;

import com.rectangulared.pizzabuilder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
