package main.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import main.model.Food;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class DishResponseDTO {
    private double totalCalories;
    private List<FoodResponseDTO> foods;
    private FoodResponseDTO higherCalorie;
}
