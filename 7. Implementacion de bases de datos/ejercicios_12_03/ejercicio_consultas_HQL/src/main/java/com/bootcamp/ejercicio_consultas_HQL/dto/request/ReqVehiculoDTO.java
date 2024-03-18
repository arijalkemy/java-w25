package com.bootcamp.ejercicio_consultas_HQL.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqVehiculoDTO {
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("anyo_fabricacion")
    private Integer anyoFabricacion;
    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;
}
