package com.meli.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class Dish {
    private String name;
    private Map<Ingredient,Double> ingredientsAndPercentage;

}
