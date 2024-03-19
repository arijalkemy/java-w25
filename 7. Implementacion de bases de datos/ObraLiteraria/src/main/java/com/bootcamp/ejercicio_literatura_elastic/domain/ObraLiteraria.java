package com.bootcamp.ejercicio_literatura_elastic.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "obra")
public class ObraLiteraria {

    @Id
    String id;
    String nombre;
    String autor;
    Integer cantidadPaginas;
    String editorial;
    @Field(type = FieldType.Date)
    LocalDate anioPublicacion;
}
