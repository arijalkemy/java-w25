package com.example.ElasticDemo01.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName = "obras_literarias")
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    String autor;
    Integer cantidadPaginas;
    String editorial;
    @Field(type = FieldType.Date)
    LocalDate fechaPublicacion;

    public ObraLiteraria(String nombre, String autor, Integer cantidadPaginas, String editorial, LocalDate fechaPublicacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }
}
