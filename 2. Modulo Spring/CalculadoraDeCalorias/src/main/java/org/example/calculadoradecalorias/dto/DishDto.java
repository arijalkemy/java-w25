package org.example.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private String name;
    private List<IngredientDto> ingredients;
}
