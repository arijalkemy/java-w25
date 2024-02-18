package com.springboot.ejerciciodeportista.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeporteCompletoDTO {
    private String nombre;
    private String nivel;
}

