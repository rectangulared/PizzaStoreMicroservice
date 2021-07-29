package com.rectangulared.pizzacart.controller;

import com.rectangulared.common.entity.Pizza;
import com.rectangulared.pizzacart.service.PizzaCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
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
