package com.example.ejercicio_calorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String name;
    private int weight;
    private int calories;
    private List<Ingredient> ingredients;
}
