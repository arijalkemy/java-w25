package com.meli.showroom.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

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
    int cantidad;
    double precio_venta;
    @ManyToOne
    @JoinColumn(name="venta_id")
    Venta venta;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
