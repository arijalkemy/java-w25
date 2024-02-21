package ejercicio.caloriascalcu.dto;

import ejercicio.caloriascalcu.entity.Ingrediente;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlatoDTO {
     String name;
     List<IngredienteDTO> ingredientes;
}
