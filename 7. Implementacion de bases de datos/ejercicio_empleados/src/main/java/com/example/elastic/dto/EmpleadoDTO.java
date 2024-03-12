package com.example.elastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private String nombre;
    private String apellido;
    private String ciudad;
    private String estado;
}
