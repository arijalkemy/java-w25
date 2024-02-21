package ejercicio.caloriascalcu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredienteDTO {
    private String nombre;
    private double calorias;
}
