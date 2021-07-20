package com.rectangulared.pizzaviewer.service;

import com.rectangulared.pizzaviewer.entity.Ingredient;
import com.rectangulared.pizzaviewer.entity.Pizza;
import com.rectangulared.pizzaviewer.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PizzaViewerService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaViewerService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizzas(){
        List<Pizza> pizzas = pizzaRepository.findPizzaByDefaultPizzaIsTrue();
        for (Pizza pizza : pizzas) {
            double price = pizza.getIngredients().stream().mapToDouble(Ingredient::getPrice).sum();
            pizza.setPrice(price);
        }
        return pizzas;
    }
}
