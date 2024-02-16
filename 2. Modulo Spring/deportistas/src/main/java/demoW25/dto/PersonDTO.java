package demoW25.dto;

import demoW25.model.Sports;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonDTO {

    private String nombre;
    private String apellido;
    private String deporte;
}
