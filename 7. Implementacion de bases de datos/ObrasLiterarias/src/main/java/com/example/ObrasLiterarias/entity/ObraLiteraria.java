package com.example.ObrasLiterarias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "obras_literarias")
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    String autor;
    @JsonProperty("cantidad_paginas")
    Integer cantidadPaginas;
    String editorial;
    @JsonProperty("anio_publicacion")
    Integer anioPublicacion;

    public ObraLiteraria(String nombre, String autor, Integer cantidadPaginas, String editorial, Integer anioPublicacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
    }
}
