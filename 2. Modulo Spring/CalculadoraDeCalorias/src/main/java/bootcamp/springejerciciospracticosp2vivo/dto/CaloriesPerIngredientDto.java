package bootcamp.springejerciciospracticosp2vivo.dto;

import bootcamp.springejerciciospracticosp2vivo.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaloriesPerIngredientDto {

    private List<Ingredient> caloriesPerIngredient;

}
