package com.bootcamp.ejercicio_showroom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "prendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    private Double precio_venta;

    public Prenda(String nombre, String tipo, String marca, String color, String talle, Integer cantidad, Double precio_venta) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
        this.talle = talle;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
    }
}
