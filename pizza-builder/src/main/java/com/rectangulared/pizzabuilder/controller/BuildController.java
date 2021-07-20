package com.rectangulared.pizzabuilder.controller;

import com.rectangulared.pizzabuilder.entity.Ingredient;
import com.rectangulared.pizzabuilder.entity.Pizza;
import com.rectangulared.pizzabuilder.entity.PizzaDTO;
import com.rectangulared.pizzabuilder.entity.PizzasForm;
import com.rectangulared.pizzabuilder.service.PizzaViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/builder")
public class BuildController {

    private final PizzaViewerService pizzaViewerService;

    @Autowired
    public BuildController(PizzaViewerService pizzaViewerService) {
        this.pizzaViewerService = pizzaViewerService;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return pizzaViewerService.getAllIngredients();
    }

    @GetMapping("/form")
    public PizzasForm[] getAllForms() { return PizzasForm.values(); };

    @PostMapping
    public Pizza getPizza(@RequestBody PizzaDTO pizzaDTO) {
        return pizzaViewerService.addPizza(pizzaDTO);
    }
}
