package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.dto.response.DishDTO;
import com.meli.calculadoracalorias.entity.Dish;
import com.meli.calculadoracalorias.entity.Ingredient;
import com.meli.calculadoracalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;


@Service
public class CaloriesCalculatorServiceImpl implements CaloriesCalculatorService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public CaloriesCalculatorServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Optional<DishDTO> getInfo(String name, Double weight){

        Optional<Dish> dish = getDishes().stream()
                .filter(x -> x.getName().equalsIgnoreCase(name)).findFirst();

        if(dish.isEmpty()){
            return Optional.empty();
        }

        DishDTO dishDTO = calculateCalories(dish.get(),weight);

        return Optional.of(dishDTO);
    }

    private DishDTO calculateCalories(Dish dish,Double weight){

        Map<Ingredient,Double> ingredientsAndPercentage = dish.getIngredientsAndPercentage();
        DishDTO dishDTO = new DishDTO();

        double weigthPerIngredient = 0.0;
        double caloriesPerIngredient = 0.0;
        double totalCalories = 0.0;

        double maxCaloriesValue = 0.0;
        String maxCaloriesIngredient = "";

        Map<String,Double> ingredientsAndCalories = new HashMap<>();

        for (Map.Entry<Ingredient,Double> ingredient: ingredientsAndPercentage.entrySet()) {
            weigthPerIngredient = weight * ingredient.getValue();

            //REGLA DE 3
            caloriesPerIngredient = (weigthPerIngredient * ingredient.getKey().getCalories())/100;

            ingredientsAndCalories.put(ingredient.getKey().getName(),caloriesPerIngredient);

            //INGREDIENTE CON MAYOR CALORIAS
            if(maxCaloriesValue < caloriesPerIngredient){
                maxCaloriesValue = caloriesPerIngredient;
                maxCaloriesIngredient = ingredient.getKey().getName();
            }

            //TOTAL CALORIAS DEL PLATO
            totalCalories = totalCalories + caloriesPerIngredient;
        }

        dishDTO.setTotalCalories(totalCalories);
        dishDTO.setHighestCaloriesIngredient(maxCaloriesIngredient);
        dishDTO.setIngredientsAndCalories(ingredientsAndCalories);


        return dishDTO;
    }

    private List<Dish> getDishes(){
        List<Dish> dishes = new ArrayList<>();


        Dish pizza = new Dish("Pizza",
                Map.of(ingredientRepository.findByName("Champiñón y otras setas").get(),0.50,
                        ingredientRepository.findByName("Aceitunas negras").get(),0.50
                )
        );

        Dish bread = new Dish("Bread",
                Map.of(ingredientRepository.findByName("Coco").get(),0.50,
                        ingredientRepository.findByName("Cuajada").get(),0.20,
                        ingredientRepository.findByName("Flan de huevo").get(),0.20
                )
        );

        dishes.add(pizza);
        dishes.add(bread);

        return dishes;
    }
}
