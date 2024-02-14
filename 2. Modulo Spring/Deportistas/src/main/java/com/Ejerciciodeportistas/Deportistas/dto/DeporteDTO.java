package com.Ejerciciodeportistas.Deportistas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeporteDTO {

    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
