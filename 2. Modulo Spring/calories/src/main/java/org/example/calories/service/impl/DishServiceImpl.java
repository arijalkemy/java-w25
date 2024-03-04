package org.example.calories.service.impl;

import org.example.calories.dto.dish.DishDTO;
import org.example.calories.dto.ingredient.IngredientDTO;
import org.example.calories.dto.ingredient.IngredientMapper;
import org.example.calories.entity.Ingredient;
import org.example.calories.repository.common.IDishRepository;
import org.example.calories.repository.common.IIngredientRepository;
import org.example.calories.service.common.IDishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService {

    private IDishRepository dishRepository;
    private IIngredientRepository ingredientRepository;
    public DishServiceImpl(IDishRepository dishRepository,IIngredientRepository ingredientRepository){
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }
    @Override
    public DishDTO getByNameAndWeight(String name, int weight) {

        var heatTotal = 0;
        var weightTotal = 0;
        var dish = this.dishRepository.getByName(name);
        HashMap<Ingredient,Short> ingredients = new HashMap<>();

        for(var id:dish.getIngredientsIds()) {
            var ingredient = this.ingredientRepository.getAll().get(id);

            heatTotal += ingredient.getCalories();
            weightTotal += 100;
            ingredients.put(ingredient,ingredients.containsKey(ingredient) ? (short)(ingredients.get(ingredient)+1):1);
        }

        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        ingredients.forEach((ingredient,quantity)->{
          ingredientDTOS.add(IngredientMapper.getIngredientDTO(ingredient,quantity));
        });
        var dto = new DishDTO(dish.getName(),heatTotal,ingredientDTOS,ingredients.keySet().stream()
                .max((ingredientA,ingredientB) -> ingredientA.getCalories() > ingredientB
                        .getCalories() ? 1 : -1).get());
        return weight == weightTotal ? dto : null;
    }
}
