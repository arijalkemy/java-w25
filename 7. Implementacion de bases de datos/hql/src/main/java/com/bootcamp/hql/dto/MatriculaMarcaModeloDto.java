package com.bootcamp.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaMarcaModeloDto {
    private String patente;
    private String marca;
    private String modelo;
}
