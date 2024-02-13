package org.deportistas.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Persona {
    String nombre;
    String apellido;
    Integer edad;
    Deporte deporte;
}
