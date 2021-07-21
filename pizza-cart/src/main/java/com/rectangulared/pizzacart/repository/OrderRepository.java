package com.rectangulared.pizzacart.repository;

import com.rectangulared.pizzacart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
