package main.dto;

import lombok.Data;
import main.entity.Food;

@Data
public class FoodDTO {
    private String name;
    private Integer calories;

    public FoodDTO(Food food, Integer calories) {
        this.name = food.getName();
        this.calories = calories;
    }
}
