package org.example.calculadoradecalorias.service;

import org.example.calculadoradecalorias.dto.DishDto;
import org.example.calculadoradecalorias.dto.DishIngredientsDto;
import org.example.calculadoradecalorias.dto.IngredientDto;
import org.example.calculadoradecalorias.repository.DishRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishServiceInterface{

    @Autowired
    DishRepositoryImpl dishRepository = new DishRepositoryImpl();

    @Override
    public DishDto getOneDishByName(String name) {
        Optional<DishDto> dish = dishRepository.findOneDishByName(name);
        if (dish.isEmpty()) throw new RuntimeException("El plato no existe");
        return dish.get();
    }

    @Override
    public IngredientDto ingredientWhitMoreCaloriesOf(DishDto dish) {
       return dish.getIngredients().stream().max(Comparator.comparing(IngredientDto::getCalories)).orElse(null);
    }

    @Override
    public Integer calculateDishCalories(DishDto dish) {
        return dish.getIngredients().stream().map(IngredientDto::getCalories).reduce(0, Integer::sum);
    }

    @Override
    public DishIngredientsDto showDishIngredients(DishDto dish) {
        return new DishIngredientsDto(dish.getIngredients().size(),dish.getIngredients());
    }
}
