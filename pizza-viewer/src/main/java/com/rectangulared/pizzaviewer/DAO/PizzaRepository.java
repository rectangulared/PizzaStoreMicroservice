package com.rectangulared.pizzaviewer.DAO;

import com.rectangulared.pizzaviewer.entity.Ingredient;
import com.rectangulared.pizzaviewer.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
