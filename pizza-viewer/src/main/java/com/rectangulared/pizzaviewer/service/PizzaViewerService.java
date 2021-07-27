package com.rectangulared.pizzaviewer.service;

import com.rectangulared.common.entity.Pizza;
import com.rectangulared.common.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            pizza.setPrice(pizza.calculatePrice());
        }
        return pizzas;
    }

    public Pizza getPizzaById(int id) {
        Optional<Pizza> tempPizza = pizzaRepository.findById(id);
        if (tempPizza.isPresent()) {
            Pizza pizza = tempPizza.get();
            pizza.setPrice(pizza.calculatePrice());
            return pizza;
        }
        return tempPizza.get();
    }
}
