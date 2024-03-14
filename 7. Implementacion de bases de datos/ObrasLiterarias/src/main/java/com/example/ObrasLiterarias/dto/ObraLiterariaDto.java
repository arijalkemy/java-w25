package com.example.ObrasLiterarias.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaDto {
    String nombre;
    String autor;
    @JsonProperty("cantidad_paginas")
    Integer cantidadPaginas;
    String editorial;
    @JsonProperty("anio_publicacion")
    Integer anioPublicacion;
}
