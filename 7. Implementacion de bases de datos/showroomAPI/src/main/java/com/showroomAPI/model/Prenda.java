package com.showroomAPI.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    String nombre;
    String tipo;
    String marca;
    String color;
    String talla;
    Integer cantidad;
    Double precio;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = true)
    Venta venta;

}
