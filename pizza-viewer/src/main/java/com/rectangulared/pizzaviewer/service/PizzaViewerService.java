package com.rectangulared.pizzaviewer.service;

import com.rectangulared.pizzaviewer.DAO.IngredientRepository;
import com.rectangulared.pizzaviewer.DAO.PizzaRepository;
import com.rectangulared.pizzaviewer.entity.Ingredient;
import com.rectangulared.pizzaviewer.entity.Pizza;
import com.rectangulared.pizzaviewer.entity.PizzaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PizzaViewerService {

    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private IngredientRepository ingredientRepository;


    public Pizza addPizza(PizzaDTO pizzaDTO) {
        List<Ingredient> ingredients = ingredientRepository.findAllByIdIn(Arrays.asList(pizzaDTO.getIngredients()));
        Pizza pizza = new Pizza(pizzaDTO, ingredients);
        return pizzaRepository.save(pizza);
    }
}
