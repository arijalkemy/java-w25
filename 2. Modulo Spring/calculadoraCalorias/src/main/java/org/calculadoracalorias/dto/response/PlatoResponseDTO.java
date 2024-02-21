package org.calculadoracalorias.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.calculadoracalorias.entity.Ingrediente;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlatoResponseDTO {
    Double totalCalories;
    Ingrediente ingredienteMasCalorico;
    List<IngredienteResponseDTO> ingredientes;

    public PlatoResponseDTO() {
        ingredientes = new ArrayList<>();
    }
}
