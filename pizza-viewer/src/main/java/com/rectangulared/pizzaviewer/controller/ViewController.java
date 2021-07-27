package com.rectangulared.pizzaviewer.controller;

import com.rectangulared.common.entity.Pizza;
import com.rectangulared.pizzaviewer.service.PizzaViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
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

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable int id) {
        return pizzaViewerService.getPizzaById(id);
    }
}
