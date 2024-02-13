package calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientCaloriesDTO {
    // Este es el ingrediente en tabla, no es el ingrediente en plato.
    // Aquí sabemos la cantidad de calorias que tiene un ingrediente cada 100 g.
    // No es la cantidad de ingrediente en un plato! No usar como componente de plato!

    private String name;
    private int calories;
}
