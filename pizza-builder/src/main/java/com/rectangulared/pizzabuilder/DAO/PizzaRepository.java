package com.rectangulared.pizzabuilder.DAO;

import com.rectangulared.pizzabuilder.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
