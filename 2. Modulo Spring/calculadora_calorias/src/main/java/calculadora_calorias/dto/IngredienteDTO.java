package calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredienteDTO {
    private String name;
    private double calories;
}
