package org.calculadoracalorias.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.calculadoracalorias.entity.Ingrediente;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IngredienteResponseDTO {
    Ingrediente ingrediente;
    Double calorias;
    Double peso;
}
