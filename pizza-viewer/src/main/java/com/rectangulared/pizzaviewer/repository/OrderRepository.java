package com.rectangulared.pizzaviewer.repository;

import com.rectangulared.pizzaviewer.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
