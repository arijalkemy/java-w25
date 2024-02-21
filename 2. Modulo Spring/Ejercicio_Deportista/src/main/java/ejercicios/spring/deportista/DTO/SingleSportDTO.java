package ejercicios.spring.deportista.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SingleSportDTO {
    private String nombre;
    private String nivel;
}
