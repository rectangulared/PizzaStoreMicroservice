package com.rectangulared.pizzabuilder.controller;

import com.rectangulared.pizzabuilder.entity.Ingredient;
import com.rectangulared.pizzabuilder.entity.Pizza;
import com.rectangulared.pizzabuilder.entity.PizzaDTO;
import com.rectangulared.pizzabuilder.entity.PizzasForm;
import com.rectangulared.pizzabuilder.service.PizzaBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/forms")
    public PizzasForm[] getAllForms() { return PizzasForm.values(); };

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaForEdit(@PathVariable("id") int id) {
        Pizza pizza = pizzaBuilderService.getPizzaById(id);
        if (pizza == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pizza);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePizza(@PathVariable("id") int id, @RequestBody PizzaDTO pizzaDTO) {
        pizzaBuilderService.savePizzaById(id, pizzaDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> addPizza(@RequestBody @Valid PizzaDTO pizzaDTO) {
        pizzaBuilderService.addPizza(pizzaDTO);
        return ResponseEntity.noContent().build();
    }
}
