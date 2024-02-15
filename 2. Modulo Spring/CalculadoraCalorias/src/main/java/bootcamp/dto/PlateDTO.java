package bootcamp.dto;

import bootcamp.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateDTO {
    private double caloriasTotales;

    //Es mejor usar el Food o crear un DTO de Food con los mismos atributos
    private List<Food> ingredients;
    private String ingredienteMasCalorico;

}
