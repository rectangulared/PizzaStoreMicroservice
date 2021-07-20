package com.rectangulared.pizzacart.service;

import com.rectangulared.pizzacart.entity.Pizza;
import com.rectangulared.pizzacart.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaCartService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaCartService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizzaFromOrder(List<Integer> ids) {
        return pizzaRepository.findAllByIdIn(ids);
    }

}
