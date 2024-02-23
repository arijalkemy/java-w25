package com.mercadolibre.calculadoracalorias.service;

import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {
  private final IngredientRepository ingredientRepository;

  public DishServiceImpl(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  @Override
  public DishResponseDTO calculateCalories(DishDTO dish) {
    DishResponseDTO response = new DishResponseDTO(dish);
    int total = 0;
    int maxCalories = 0;
    for (IngredientDTO ingredient : response.getIngredients()) {
      calculateIngredientCalories(ingredient);
      total += ingredient.getCalories();
      if (ingredient.getCalories() > maxCalories) {
        response.setCaloric(ingredient);
        maxCalories = ingredient.getCalories();
      }
    }
    response.setCalories(total);
    return response;
  }

  @Override
  public List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes) {
    List<DishResponseDTO> result = new ArrayList<>();
    for (DishDTO dish : dishes) {
      result.add(this.calculateCalories(dish));
    }
    return result;
  }

  private void calculateIngredientCalories(IngredientDTO ingredient) {
    ingredient.setCalories(0);
    IngredientDTO ingredientFromRepository = ingredientRepository.findIngredientByName(ingredient.getName());
    if (ingredientFromRepository != null)
      ingredient.setCalories((int) (ingredient.getWeight() * ingredientFromRepository.getCalories() / 100.f));
  }
}
