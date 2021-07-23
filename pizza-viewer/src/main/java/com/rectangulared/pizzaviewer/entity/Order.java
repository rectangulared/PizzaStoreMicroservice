package com.rectangulared.pizzaviewer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @ManyToMany
    @JoinTable(name = "orders_pizzas",
            joinColumns = { @JoinColumn(name="order_id") },
            inverseJoinColumns = { @JoinColumn(name = "pizza_id") }
    )
    @JsonIgnore
    private List<Pizza> pizzas;

    public Order(int id, Date createdAt, List<Pizza> pizzas) {
        this.id = id;
        this.createdAt = createdAt;
        this.pizzas = pizzas;
    }
}
