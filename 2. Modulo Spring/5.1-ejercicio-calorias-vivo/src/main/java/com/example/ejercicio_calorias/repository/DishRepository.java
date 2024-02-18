package com.example.ejercicio_calorias.repository;

import com.example.ejercicio_calorias.model.Dish;
import com.example.ejercicio_calorias.model.Ingredient;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {
    @Getter
    private List<Dish> dishes;
    private final IngredientRepository ingredientRepository;

    public DishRepository(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
        List<Ingredient> pizzaIngredients = List.of(
                this.ingredientRepository.getByName("Queso mozzarella"),
                this.ingredientRepository.getByName("Harina de maíz"));
        List<Ingredient> papasFritasIngredients = List.of(
                this.ingredientRepository.getByName("Papas cocidas"),
                this.ingredientRepository.getByName("Queso cheddar"));
        dishes = List.of(
                new Dish("Pizza muza", 600, 300, pizzaIngredients),
                new Dish("Papas fritas", 600, 200, papasFritasIngredients)
        );
    }


    public Dish getByName(String name) {
        return dishes.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
