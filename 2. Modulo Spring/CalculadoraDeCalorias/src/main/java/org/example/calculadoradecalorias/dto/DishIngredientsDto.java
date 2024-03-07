package org.example.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishIngredientsDto {
    private Integer ingredients;
    private List<IngredientDto> ingredientsList;
}
