package calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {
    // Este es el ingrediente en el plato (que sabemos nombre y gramos,  pero debemos calcular calorias que aporta)
    private int grams;
    private String name;
    private double calories;

    public Ingredient(int grams, String name) {
        this.grams = grams;
        this.name = name;
        this.calories = calories;
    }
}
