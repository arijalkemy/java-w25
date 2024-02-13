package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.Food;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DishResponseDTO {
    private double totalCalories;
    private List<FoodResponseDTO> foods;
    private FoodResponseDTO higherCalorie;
}
