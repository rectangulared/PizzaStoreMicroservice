package com.rectangulared.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    @Column
    private double price;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnore
    private List<Pizza> pizzas;

    public Ingredient(String name, IngredientType type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
