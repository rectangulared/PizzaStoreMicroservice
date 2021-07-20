package com.rectangulared.pizzabuilder.controller;

import com.rectangulared.pizzabuilder.entity.Ingredient;
import com.rectangulared.pizzabuilder.entity.Pizza;
import com.rectangulared.pizzabuilder.entity.PizzaDTO;
import com.rectangulared.pizzabuilder.entity.PizzasForm;
import com.rectangulared.pizzabuilder.service.PizzaBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/builder")
public class BuildController {

    private final PizzaBuilderService pizzaBuilderService;

    @Autowired
    public BuildController(PizzaBuilderService pizzaBuilderService) {
        this.pizzaBuilderService = pizzaBuilderService;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return pizzaBuilderService.getAllIngredients();
    }

    @GetMapping("/form")
    public PizzasForm[] getAllForms() { return PizzasForm.values(); };

    @PostMapping
    public Pizza addPizza(@RequestBody PizzaDTO pizzaDTO) {
        return pizzaBuilderService.addPizza(pizzaDTO);
    }
}
