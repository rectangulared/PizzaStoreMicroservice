package com.rectangulared.pizzacart.controller;

import com.rectangulared.pizzacart.entity.Pizza;
import com.rectangulared.pizzacart.service.PizzaCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CartController {

    public final PizzaCartService pizzaCartService;

    @Autowired
    public CartController(PizzaCartService pizzaCartService) {
        this.pizzaCartService = pizzaCartService;
    }

    @PostMapping
    public List<Pizza> packOrder(@RequestBody List<Integer> ids) {
        return pizzaCartService.getPizzaFromOrder(ids);
    }
}
