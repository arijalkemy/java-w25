package com.example.deportistas.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeportePersonaDTO {

    private String nombre;
    private String apellido;
    private String deporteNombre;


}
