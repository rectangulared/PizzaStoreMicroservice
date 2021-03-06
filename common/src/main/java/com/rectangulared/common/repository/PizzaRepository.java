package com.rectangulared.common.repository;

import com.rectangulared.common.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    List<Pizza> findAllByIdIn(List<Integer> ids);

    List<Pizza> findPizzaByDefaultPizzaIsTrue();
}
