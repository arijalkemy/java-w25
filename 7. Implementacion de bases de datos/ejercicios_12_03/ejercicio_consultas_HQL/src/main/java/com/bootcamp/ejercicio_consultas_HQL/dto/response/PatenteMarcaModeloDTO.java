package com.bootcamp.ejercicio_consultas_HQL.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatenteMarcaModeloDTO {
    private String patente;
    private String marca;
    private String modelo;
}
