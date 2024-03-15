package com.example.ElasticDemo01.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "obras")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Obra {


    @Id
    String id;
    String nombre;
    String autor;
    int cantidad_paginas;
    String editorial;
    int anio;

    public Obra(String nombre, String autor, int cantidad_paginas, String editorial, int anio) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidad_paginas = cantidad_paginas;
        this.editorial = editorial;
        this.anio = anio;
    }
}
