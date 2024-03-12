package com.example.ejercicio_obras.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "obras")
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    String autor;
    Integer paginas;
    String editorial;
    Integer anio;
}
