package com.rectangulared.pizzacart.service;

import com.rectangulared.pizzacart.entity.Order;
import com.rectangulared.pizzacart.entity.Pizza;
import com.rectangulared.pizzacart.repository.OrderRepository;
import com.rectangulared.pizzacart.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaCartService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public PizzaCartService(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    public List<Pizza> getPizzaFromOrder(List<Integer> ids) {
        List<Pizza> pizzas = pizzaRepository.findAllByIdIn(ids);
        orderRepository.save(new Order(-1, null, pizzas));
        for(Pizza pizza : pizzas) {
            pizza.setPrice(pizza.calculatePrice());
        }
        return pizzas;
    }

}
