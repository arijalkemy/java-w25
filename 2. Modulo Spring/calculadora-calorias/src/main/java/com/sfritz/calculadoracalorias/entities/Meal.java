package com.sfritz.calculadoracalorias.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meal {
    private String name;
    private List<Ingredient> ingredients;
}
