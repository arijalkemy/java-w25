package demoW25.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private String nombre;
    private String apellido;
    private Integer edad;
    private Sports deporte;

}
