package com.bootcamp.ejercicio_empleados_elastic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Direccion {
    private String ciudad;
    private String Localidad;
    private String provincia;
}
