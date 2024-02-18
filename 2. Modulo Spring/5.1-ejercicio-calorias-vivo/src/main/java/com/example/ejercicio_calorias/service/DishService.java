package com.example.ejercicio_calorias.service;

import com.example.ejercicio_calorias.dto.DishCaloriesDTO;
import com.example.ejercicio_calorias.dto.DishIngredientDTO;
import com.example.ejercicio_calorias.dto.DishIngredientsDTO;
import com.example.ejercicio_calorias.model.Ingredient;
import com.example.ejercicio_calorias.model.Dish;
import com.example.ejercicio_calorias.repository.DishRepository;
import com.example.ejercicio_calorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class DishService implements IDishService{

    private final DishRepository repository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public DishService(DishRepository repository, IngredientRepository ingredientRepository) {
        this.repository = repository;
        this.ingredientRepository = ingredientRepository;
    }
    public DishCaloriesDTO calculateTotalCalories(String name, int weight){
        Dish dish = repository.getByName(name);

        int totalCalories = 0;

        for (int i = 0; i < dish.getIngredients().size(); i++) {
            totalCalories += (dish.getIngredients().get(i).getCalories() * weight) / 100;
        }

        return new DishCaloriesDTO(totalCalories);
    }

    public DishIngredientsDTO getIngredients(String name, int weight){
        Dish dish = repository.getByName(name);

        List<DishIngredientDTO> dishIngredientDTOList = new ArrayList<>();
        for (int i = 0; i < dish.getIngredients().size(); i++) {
            DishIngredientDTO dishIngredientDTO = new DishIngredientDTO();

            dishIngredientDTO.setName(dish.getIngredients().get(i).getName());
            dishIngredientDTO.setCalories((dish.getIngredients().get(i).getCalories() * weight) / 100);

            dishIngredientDTOList.add(dishIngredientDTO);
        }

        return new DishIngredientsDTO(dishIngredientDTOList);
    }

    public DishIngredientDTO getIngredientWithMoreCalories(String name, int weight){
        Dish dish = repository.getByName(name);
        Ingredient ingredient = dish.getIngredients().stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .orElse(null);

        return new DishIngredientDTO(ingredient.getName(), (ingredient.getCalories() * weight) / 100);
    }

}

