package com.example.calorias.service;

import com.example.calorias.dto.DishDto;
import com.example.calorias.entity.Dish;
import com.example.calorias.entity.Food;
import com.example.calorias.repository.DishRepositoryImp;
import com.example.calorias.repository.FoodRepositoryImp;

import java.util.List;

public class DishService {
    FoodRepositoryImp foodRepository;
    DishRepositoryImp dishRepository;

    public DishService() {
        foodRepository = new FoodRepositoryImp();
        dishRepository = new DishRepositoryImp();
    }

    public Food getMaxCaloriesFood() {
        List<Food> ingredientes = foodRepository.findAll();
        Food result = ingredientes
                .stream()
                .max((food1, food2) -> Integer.compare(food1.getCalories(), food2.getCalories()))
                .orElse(null);
        return result;
    }

    public DishDto getIngredients(String dish) {
        List<Dish> dishes = dishRepository.findAll();
        Food dishFound = (Food) dishes
                .stream()
                .filter(i -> i.getName().equals(dish));
        DishDto dishInfo = new DishDto(new Dish(dishFound.getName(), dishFound.getCalories()));
    }
}
