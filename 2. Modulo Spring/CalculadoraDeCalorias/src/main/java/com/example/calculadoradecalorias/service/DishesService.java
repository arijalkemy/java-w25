package com.example.calculadoradecalorias.service;

import com.example.calculadoradecalorias.dto.PlatoCaloriasDTO;
import com.example.calculadoradecalorias.dto.PlatoIngredientesDTO;
import com.example.calculadoradecalorias.dto.PlatoMostCalories;
import com.example.calculadoradecalorias.entity.Ingrediente;
import com.example.calculadoradecalorias.entity.IngredientePlato;
import com.example.calculadoradecalorias.entity.Plato;
import com.example.calculadoradecalorias.repository.DishesRepositoryImp;
import com.example.calculadoradecalorias.repository.FoodRespositoryImp;
import com.example.calculadoradecalorias.repository.IDishedRepository;
import com.example.calculadoradecalorias.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class DishesService implements IDishesService{

    private IDishedRepository dishesRepository;
    private IFoodRepository ingredients;

    @Autowired
    public DishesService(DishesRepositoryImp dishesRepository, FoodRespositoryImp ingredients) {
        this.dishesRepository = dishesRepository;
        this.ingredients = ingredients;
    }

    public PlatoCaloriasDTO getDishCalories(String plato){
        AtomicInteger totalCalories = new AtomicInteger();
        Plato dishfound = dishesRepository.getDishes().stream().filter(dish -> dish.getNombre().equals(plato)).findFirst().orElse(null);
        if (dishfound == null) {
            return new PlatoCaloriasDTO(0);
        } else {
            dishfound.getIngredientes().forEach(ingredient -> {
                int caloriesPer100Grams = ingredients.getIngredientes().stream()
                        .filter(ing -> ing.getName().equals(ingredient.getName()))
                        .findFirst()
                        .orElse(null)
                        .getCalories();
                totalCalories.addAndGet((ingredient.getGramos() * caloriesPer100Grams) / 100);
            });
            return new PlatoCaloriasDTO(totalCalories.get());
        }
    }

    public PlatoIngredientesDTO getDishIngredientsAndCalories(String plato){
        Plato dishfound = dishesRepository.getDishes().stream().filter(dish -> dish.getNombre().equals(plato)).findFirst().orElse(null);
        List<Ingrediente> ingredientsList = dishfound.getIngredientes().stream().map(ingredient -> {
            Ingrediente ing = ingredients.getIngredientes().stream().filter(i -> i.getName().equals(ingredient.getName())).findFirst().orElse(null);
            int calories = ing != null ? (ing.getCalories() * ingredient.getGramos()) / 100 : 0;
            return new Ingrediente(ingredient.getName(), calories);
        }).collect(Collectors.toList());
        return new PlatoIngredientesDTO(ingredientsList);
    }

    public PlatoMostCalories getMostCaloriesIngredient(String plato){
        Plato dishfound = dishesRepository.getDishes().stream().filter(dish -> dish.getNombre().equals(plato)).findFirst().orElse(null);
        if (dishfound == null) {
            return new PlatoMostCalories("");
        } else {
            Ingrediente maxCalorieIngredient = dishfound.getIngredientes().stream()
                    .map(ingredient -> new Ingrediente(ingredient.getName(), (ingredients.getIngredientes().stream()
                            .filter(i -> i.getName().equals(ingredient.getName()))
                            .findFirst().orElse(new Ingrediente("", 0)).getCalories() * ingredient.getGramos()) / 100))
                    .max(Comparator.comparingInt(Ingrediente::getCalories))
                    .orElse(new Ingrediente("", 0));
            return new PlatoMostCalories(maxCalorieIngredient.getName());
        }
    }





}
