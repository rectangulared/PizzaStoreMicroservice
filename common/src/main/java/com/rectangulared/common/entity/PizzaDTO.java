package com.rectangulared.common.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PizzaDTO {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private Integer[] ingredients;

    @NotNull
    private PizzasForm pizzasForm;

    @NotNull
    private boolean hasCheeseBoards;

    @NotNull
    private boolean defaultPizza;

    public PizzaDTO(String name, Integer[] ingredients, PizzasForm pizzasForm, boolean hasCheeseBoards, boolean defaultPizza) {
        this.name = name;
        this.ingredients = ingredients;
        this.pizzasForm = pizzasForm;
        this.hasCheeseBoards = hasCheeseBoards;
        this.defaultPizza = defaultPizza;
    }
}
