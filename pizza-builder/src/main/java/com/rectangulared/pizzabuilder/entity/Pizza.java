package com.rectangulared.pizzabuilder.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "pizza_presets")
@Data
@NoArgsConstructor
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

    public Pizza(PizzaDTO pizzaDTO, List<Ingredient> ingredients) {
        this.id = -1;
        this.name = pizzaDTO.getName();
        this.ingredients = ingredients;
        this.pizzasForm = pizzaDTO.getPizzasForm();
        this.hasCheeseBoards = pizzaDTO.isHasCheeseBoards();
        this.defaultPizza = pizzaDTO.isDefaultPizza();
    }

    public double calculatePrice() {
        double price = ingredients.stream().mapToDouble(Ingredient::getPrice).sum() * pizzasForm.getPriceFactor();
        return price;
    }
}

