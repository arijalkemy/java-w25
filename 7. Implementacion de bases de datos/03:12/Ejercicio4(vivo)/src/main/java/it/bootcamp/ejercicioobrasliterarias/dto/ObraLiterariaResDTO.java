package it.bootcamp.ejercicioobrasliterarias.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraLiterariaResDTO {
    @JsonProperty("id")
    String id;

    @JsonProperty("nombre")
    String nombre;

    @JsonProperty("autor")
    String autor;

    @JsonProperty("cantidad_paginas")
    Integer cantidadPaginas;

    @JsonProperty("editorial")
    String editorial;

    @JsonProperty("anyo_primera_publicacion")
    Integer anyoPrimeraPublicacion;
}
