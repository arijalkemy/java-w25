package com.bootcamp.ejercicio_consultas_HQL.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatenteYMarcaDTO {
    private String patente;
    private String marca;
}
