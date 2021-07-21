package com.rectangulared.pizzabuilder.service;

import com.rectangulared.pizzabuilder.entity.Ingredient;
import com.rectangulared.pizzabuilder.entity.Pizza;
import com.rectangulared.pizzabuilder.entity.PizzaDTO;
import com.rectangulared.pizzabuilder.repository.IngredientRepository;
import com.rectangulared.pizzabuilder.repository.PizzaRepository;
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
        Optional<Pizza> tempPizza = pizzaRepository.findById(id);
        if (tempPizza.isPresent()) {
            Pizza pizza = tempPizza.get();
            pizza.setPrice(pizza.calculatePrice());
            return pizza;
        }
        return tempPizza.get();
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
