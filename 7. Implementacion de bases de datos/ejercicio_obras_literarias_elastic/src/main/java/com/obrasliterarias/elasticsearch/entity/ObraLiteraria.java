package com.obrasliterarias.elasticsearch.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obras_literarias")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    String autor;
    Integer numPaginas;
    String editorial;
    Integer anioPublicacion;
}

//    De cada obra literaria se debe poder almacenar el id, el nombre, autor, cantidad de páginas, editorial y el año de su primera publicación.