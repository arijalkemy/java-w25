package com.example.elasticDemo.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "clothes")
@Getter @Setter
public class Clothes {
    @Id
    String id;
    String nombre;
    String tipo;
    String marca;
    String color;
    Double talle;
    Integer cantidad;
    Double precio_venta;
}
