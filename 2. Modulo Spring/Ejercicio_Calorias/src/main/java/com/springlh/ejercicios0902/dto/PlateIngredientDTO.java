package com.springlh.ejercicios0902.dto;

import com.springlh.ejercicios0902.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateIngredientDTO {
    private String name;
    private Ingredient most_calories_ingredient;
}
