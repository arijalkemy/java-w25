package com.springlh.ejercicios0902.dto.restaurante;

import com.springlh.ejercicios0902.model.restaurante.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateIngredientDTO {
    private String name;
    private Ingredient most_calories_ingredient;
}
