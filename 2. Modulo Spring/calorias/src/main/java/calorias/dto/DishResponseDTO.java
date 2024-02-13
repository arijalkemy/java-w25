package calorias.dto;

import calorias.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishResponseDTO {

    // Pregunta: esta clase no debería heredar de DishDTO? (mucha re-escritura de codigo)?
    private String name;
    private ArrayList<Ingredient> ingredients;
    private double caloriesTotal;
    private String mostCaloricIngredient;



}
