package com.calories.calories.service;

import com.calories.calories.dto.DishDTO;
import com.calories.calories.entity.Dish;
import com.calories.calories.entity.Ingredient;
import com.calories.calories.repository.IDishRepository;
import com.calories.calories.repository.IIngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DishServiceImpl implements IDishService {
    private final IDishRepository dishRepository;
    private final IIngredientRepository ingredientRepository;

    public DishServiceImpl(IDishRepository dishRepository, IIngredientRepository ingredientRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
        loadDishes();
    }

    @Override
    public void loadDishes() {
        ArrayList<Ingredient> ingredientsBurguer = new ArrayList<>();
        ingredientsBurguer.add(this.ingredientRepository.getIngredientByName("Carne"));
        ingredientsBurguer.add(this.ingredientRepository.getIngredientByName("Lechuga"));
        ingredientsBurguer.add(this.ingredientRepository.getIngredientByName("Tomates"));
        ingredientsBurguer.add(this.ingredientRepository.getIngredientByName("Queso mozzarella"));
        dishRepository.addDish(new Dish("Hamburguesa", 100, ingredientsBurguer));
        ArrayList<Ingredient> ingredientsPizza = new ArrayList<>();
        ingredientsPizza.add(this.ingredientRepository.getIngredientByName("Masa"));
        ingredientsPizza.add(this.ingredientRepository.getIngredientByName("Queso mozzarella"));
        ingredientsPizza.add(this.ingredientRepository.getIngredientByName("Jamón"));
        ingredientsPizza.add(this.ingredientRepository.getIngredientByName("Tomates"));
        dishRepository.addDish(new Dish("Pizza", 150, ingredientsPizza));
    }

    @Override
    public DishDTO getDishByName(String name, int grams) {
        Dish dish = this.dishRepository.getDishByName(name, grams);
        Ingredient mostCaloriesIngredient = dish.getIngredients().stream().max((ingredient1, ingredient2) -> ingredient1.getCalories() - ingredient2.getCalories()).orElse(null);
        return new DishDTO(dish.getCalories(), dish.getIngredients(), mostCaloriesIngredient);
    }
}
