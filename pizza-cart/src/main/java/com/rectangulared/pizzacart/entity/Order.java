package com.rectangulared.pizzacart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
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

    public Order() {}

    public Order(int id, Date createdAt, List<Pizza> pizzas) {
        this.id = id;
        this.createdAt = createdAt;
        this.pizzas = pizzas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date timeStamp) {
        this.createdAt = timeStamp;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
