package com.rectangulared.pizzabuilder.repository;

import com.rectangulared.pizzabuilder.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
