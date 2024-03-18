package com.bootcamp.ejercicio_consultas_HQL.dto.response;

import com.bootcamp.ejercicio_consultas_HQL.entity.Siniestro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResVehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("anyo_fabricacion")
    private Integer anyoFabricacion;
    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;
}
