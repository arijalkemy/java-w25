package com.implementacionbd.ejercicio.model;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Document(indexName = "prendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Prenda {

    public Prenda(String nombre, String tipo, String marca, String color, String talle, Integer cantidad,
            Double precioVenta) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
        this.talle = talle;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    @Id
    String id;

    @Field(name = "nombre")
    String nombre;

    @Field(name = "tipo")
    String tipo;

    @Field(name = "marca")
    String marca;

    @Field(name = "color")
    String color;

    @Field(name = "talle")
    String talle;

    @Field(name = "cantidad")
    Integer cantidad;

    @Field(name = "precio_enta")
    Double precioVenta;
}
