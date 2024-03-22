package com.showroom.exercise.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prendas")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String nombre;
    String tipo;
    String marca;
    String color;
    String talla;
    Integer cantidad;
    @Column(name = "precio_venta")
    Double precioVenta;

    @ManyToOne
    @JoinColumn(name = "num_venta", referencedColumnName = "numero")
    Venta venta;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
