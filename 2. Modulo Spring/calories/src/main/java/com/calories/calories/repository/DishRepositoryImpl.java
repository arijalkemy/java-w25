package com.calories.calories.repository;


import com.calories.calories.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DishRepositoryImpl implements IDishRepository {
    private ArrayList<Dish> dishes = new ArrayList<Dish>();

    @Override
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    @Override
    public ArrayList<Dish> getAll() {
        return dishes;
    }

    @Override
    public Dish getDishByName(String name, int grams) {
        return dishes.stream().filter(dish -> dish.getName().equals(name) && dish.getGrams() == grams).findFirst().orElse(null);
    }
}
