package com.joyeria.Joyeria.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JoyaRequestDTO {
    String nombre;
    String material;
    String particularidad;
    Double peso;
    Boolean posee_piedra;
    Boolean ventaONo;
}
