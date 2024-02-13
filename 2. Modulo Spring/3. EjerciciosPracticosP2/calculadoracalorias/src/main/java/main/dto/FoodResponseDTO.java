package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.Food;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodResponseDTO {
    private String name;
    private String calories;


    public FoodResponseDTO(Food food){
        this.name = food.getName();
        this.calories = food.getCalories();
    }
}
