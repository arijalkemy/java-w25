package ejercicios.spring.deportista.DTO;

import ejercicios.spring.deportista.Model.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeportistaDTO {
    private String nombre;
    private String nombreDeporte;
}
