package org.example.calories.repository.impl;

import org.example.calories.entity.Dish;
import org.example.calories.repository.common.IDishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishRepositoryImpl implements IDishRepository {

    private List<Dish> dish;

    public DishRepositoryImpl(){
        this.dish = List.of(
                new Dish("Ensalada Mediterránea",List.of(0,1,6,38,38)),
                new Dish("Pizza Vegetariana",List.of(99,99,13,13,30,11,20)),
                new Dish("Crema de Verduras",List.of(10,32,40,27,27,16)),
                new Dish("Ensalada de Frutas",List.of(56,59,81,58,58,78)),
                new Dish("Gazpacho Andaluz",List.of(37,28,28,30,3,210))
        );
    }
    @Override
    public Dish getByName(String name) {
        return this.dish.stream().filter(dish -> dish.getName().toUpperCase().equals(name.toUpperCase())).findFirst()
                .get();
    }
}
