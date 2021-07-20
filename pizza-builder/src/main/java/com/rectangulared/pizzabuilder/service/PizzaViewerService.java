package com.rectangulared.pizzabuilder.service;

import com.rectangulared.pizzabuilder.DAO.IngredientRepository;
import com.rectangulared.pizzabuilder.DAO.PizzaRepository;
import com.rectangulared.pizzabuilder.entity.Ingredient;
import com.rectangulared.pizzabuilder.entity.Pizza;
import com.rectangulared.pizzabuilder.entity.PizzaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class PizzaViewerService {

    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Pizza addPizza(PizzaDTO pizzaDTO) {
        List<Ingredient> ingredients = ingredientRepository.findAllByIdIn(Arrays.asList(pizzaDTO.getIngredients()));
        Pizza pizza = new Pizza(pizzaDTO, ingredients);
        return pizzaRepository.save(pizza);
    }
}
