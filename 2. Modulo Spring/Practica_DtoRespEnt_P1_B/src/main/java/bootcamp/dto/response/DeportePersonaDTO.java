package bootcamp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DeportePersonaDTO {

    private String nombre;
    private String apellido;
    private String deporte;

}
