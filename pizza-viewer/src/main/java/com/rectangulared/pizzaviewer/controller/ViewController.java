package com.rectangulared.pizzaviewer.controller;

import com.rectangulared.pizzaviewer.entity.Pizza;
import com.rectangulared.pizzaviewer.service.PizzaViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewController {

    public final PizzaViewerService pizzaViewerService;

    @Autowired
    public ViewController(PizzaViewerService pizzaViewerService) {
        this.pizzaViewerService = pizzaViewerService;
    }

    @GetMapping
    public List<Pizza> getAllDefaultPizzas() {
        return pizzaViewerService.getAllPizzas();
    }
}
