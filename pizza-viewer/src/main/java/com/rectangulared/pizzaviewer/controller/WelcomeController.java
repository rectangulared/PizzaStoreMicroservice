package com.rectangulared.pizzaviewer.controller;

import com.rectangulared.pizzaviewer.entity.Pizza;
import com.rectangulared.pizzaviewer.entity.PizzaDTO;
import com.rectangulared.pizzaviewer.service.PizzaViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final PizzaViewerService pizzaViewerService;

    @Autowired
    public WelcomeController(PizzaViewerService pizzaViewerService) {
        this.pizzaViewerService = pizzaViewerService;
    }

    @GetMapping
    public String greetingUser() {
        return "hello user";
    }

    @PostMapping
    public Pizza getPizza(@RequestBody PizzaDTO pizzaDTO) {
        return pizzaViewerService.addPizza(pizzaDTO);
    }
}
