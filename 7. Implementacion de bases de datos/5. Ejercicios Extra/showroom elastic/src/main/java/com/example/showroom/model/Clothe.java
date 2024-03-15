package com.example.showroom.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "clothes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Clothe {
    @Id
    String id;
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    Double precio;

    Set<Item> items;
}
