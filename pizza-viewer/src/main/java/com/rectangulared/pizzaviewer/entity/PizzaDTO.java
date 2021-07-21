package com.rectangulared.pizzaviewer.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Integer[] ingredients) {
        this.ingredients = ingredients;
    }

    public PizzasForm getPizzasForm() {
        return pizzasForm;
    }

    public void setPizzasForm(PizzasForm pizzasForm) {
        this.pizzasForm = pizzasForm;
    }

    public boolean isHasCheeseBoards() {
        return hasCheeseBoards;
    }

    public void setHasCheeseBoards(boolean hasCheeseBoards) {
        this.hasCheeseBoards = hasCheeseBoards;
    }

    public boolean isDefaultPizza() {
        return defaultPizza;
    }

    public void setDefaultPizza(boolean defaultPizza) {
        this.defaultPizza = defaultPizza;
    }
}
