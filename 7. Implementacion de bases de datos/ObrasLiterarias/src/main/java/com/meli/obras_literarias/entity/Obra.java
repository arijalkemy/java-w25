package com.meli.obras_literarias.entity;

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
@Document(indexName = "obras")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Obra {
    @Id
    String id;
    String nombre;
    String autor;
    Integer cantPaginas;
    String editorial;
    Integer anio;
}
