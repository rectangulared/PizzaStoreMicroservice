package com.rectangulared.common.repository;

import com.rectangulared.common.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    List<Ingredient> findAllByIdIn(List<Integer> ids);
}
