package bootcamp.dto;

import bootcamp.entity.Food;
import lombok.Data;

@Data

public class FoodDTO {
    private String name;
    private Integer calories;

    public FoodDTO(Food food) {
        this.name = food.getName();
        this.calories = food.getCalories();
    }
}
