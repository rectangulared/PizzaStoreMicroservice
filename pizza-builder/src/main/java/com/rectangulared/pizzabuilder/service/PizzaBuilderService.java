package com.rectangulared.pizzabuilder.service;

import com.rectangulared.common.entity.Ingredient;
import com.rectangulared.common.entity.Pizza;
import com.rectangulared.common.entity.PizzaDTO;
import com.rectangulared.common.repository.IngredientRepository;
import com.rectangulared.common.repository.PizzaRepository;
import com.rectangulared.pizzabuilder.exception.GlobalExceptionHandler;
import com.rectangulared.pizzabuilder.exception.NotCompletePizzaException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaBuilderService {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public PizzaBuilderService(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Pizza addPizza(PizzaDTO pizzaDTO) {
        Pizza pizza = preparePizza(pizzaDTO);
        return pizzaRepository.save(pizza);
    }

    public Pizza getPizzaById(int id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotCompletePizzaException());
        pizza.setPrice(pizza.calculatePrice());
        return pizza;
    }

    public Pizza savePizzaById(int id, PizzaDTO pizzaDTO) {
        Pizza pizza = preparePizza(pizzaDTO);
        pizza.setId(id);
        return pizzaRepository.save(pizza);
    }

    private Pizza preparePizza(PizzaDTO pizzaDTO) {
        List<Ingredient> ingredients = ingredientRepository.findAllByIdIn(Arrays.asList(pizzaDTO.getIngredients()));
        return new Pizza(pizzaDTO, ingredients);
    }
}
