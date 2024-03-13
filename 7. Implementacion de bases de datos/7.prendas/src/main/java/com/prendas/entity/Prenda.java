package com.prendas.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;

    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    @Column(name = "precio_venta")
    Double precioVenta;

    @Override
    public String toString() {
        return "Prenda{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", talle='" + talle + '\'' +
                ", cantidad=" + cantidad +
                ", precioVenta=" + precioVenta +
                '}';
    }
}
