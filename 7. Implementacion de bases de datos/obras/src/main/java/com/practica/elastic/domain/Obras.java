package com.practica.elastic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName = "empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Obras {

    @Id
    private String id;
    private String name;
    private String autor;
    private Integer numeroPaginas;
    private String editorial;
    @Field(type = FieldType.Date)
    private LocalDate publicacion;
}
