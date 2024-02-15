package main.service;

import java.util.List;

import main.dto.FoodDTO;

public interface IDishService {
    public Integer getTotalCalories(String dish, Integer calories);

    public List<FoodDTO> getFoodList(String dish, Integer calories);

    public FoodDTO getMostCaloricFood(String dish, Integer calories);
}
