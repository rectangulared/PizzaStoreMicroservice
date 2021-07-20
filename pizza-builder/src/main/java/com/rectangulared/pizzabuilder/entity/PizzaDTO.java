package com.rectangulared.pizzabuilder.entity;

public class PizzaDTO {
    private String name;
    private Integer[] ingredients;
    private PizzasForm pizzasForm;
    private boolean hasCheeseBoards;
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
