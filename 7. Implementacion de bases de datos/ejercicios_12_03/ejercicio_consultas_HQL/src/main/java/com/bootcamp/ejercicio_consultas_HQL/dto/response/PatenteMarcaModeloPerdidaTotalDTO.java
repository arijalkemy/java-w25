package com.bootcamp.ejercicio_consultas_HQL.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatenteMarcaModeloPerdidaTotalDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Double perdidaTotal;
    @JsonIgnore
    private Long vehiculoId;
}
