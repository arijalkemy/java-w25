package com.obrasliterarias.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obrasliterarias2")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    String autor;
    Integer paginas;
    String editorial;
    Integer anio;
}
