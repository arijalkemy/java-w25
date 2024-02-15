package main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeportePersonaDTO {
    private String nombrePersona;
    private String apellidoPerosna;
    private String deporte;
}
