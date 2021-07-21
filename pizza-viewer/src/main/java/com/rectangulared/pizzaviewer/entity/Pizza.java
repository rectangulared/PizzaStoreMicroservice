package com.rectangulared.pizzaviewer.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pizza_presets")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    @ManyToMany
    @JoinTable(name = "pizza_ingredients",
            joinColumns = { @JoinColumn(name="pizza_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private List<Ingredient> ingredients;
    @Column
    @Enumerated(EnumType.STRING)
    private PizzasForm pizzasForm;
    @Column
    private boolean hasCheeseBoards;
    @Column
    private boolean defaultPizza;

    @Transient
    private double price;

    public Pizza() {}

    public Pizza(PizzaDTO pizzaDTO, List<Ingredient> ingredients) {
        this.id = -1;
        this.name = pizzaDTO.getName();
        this.ingredients = ingredients;
        this.pizzasForm = pizzaDTO.getPizzasForm();
        this.hasCheeseBoards = pizzaDTO.isHasCheeseBoards();
        this.defaultPizza = pizzaDTO.isDefaultPizza();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isHasCheeseBoards() {
        return hasCheeseBoards;
    }

    public void setHasCheeseBoards(boolean hasCheeseBoards) {
        this.hasCheeseBoards = hasCheeseBoards;
    }

    public PizzasForm getPizzasForm() {
        return pizzasForm;
    }

    public void setPizzasForm(PizzasForm pizzasForm) {
        this.pizzasForm = pizzasForm;
    }

    public boolean isDefaultPizza() {
        return defaultPizza;
    }

    public void setDefaultPizza(boolean defaultPizza) {
        this.defaultPizza = defaultPizza;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculatePrice() {
        double price = ingredients.stream().mapToDouble(Ingredient::getPrice).sum() * pizzasForm.getPriceFactor();
        return price;
    }
}

