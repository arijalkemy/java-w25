package com.example.ejercicio_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishIngredientDTO {
    private String name;
    private int calories;
}
