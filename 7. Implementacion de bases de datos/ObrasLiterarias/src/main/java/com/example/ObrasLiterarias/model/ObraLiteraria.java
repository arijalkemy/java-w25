package com.example.ObrasLiterarias.model;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obra-literaria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiteraria {

    String id;
    String name;
    String author;
    int pages;
    String editorial;
    int publishYear;

}

/**
 * De cada obra literaria se debe poder almacenar el id, el
 * nombre, autor, cantidad de páginas, editorial y el año de su primera publicación.
 */
