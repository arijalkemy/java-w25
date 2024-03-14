package it.bootcamp.ejercicioobrasliterarias.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "obras")
public class ObraLiteraria {
    @Id
    String id;

    @Field(name = "nombre")
    String nombre;

    @Field(name = "autor")
    String autor;

    @Field(name = "cantidad_paginas")
    Integer cantidadPaginas;

    @Field(name = "editorial")
    String editorial;

    @Field(name = "anyo_primera_publicacion")
    Integer anyoPrimeraPublicacion;
}
