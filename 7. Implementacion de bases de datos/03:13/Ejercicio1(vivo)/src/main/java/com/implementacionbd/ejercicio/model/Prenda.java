package com.implementacionbd.ejercicio.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prendas")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "nombre", nullable = false)
    String nombre;

    @Column(name = "tipo", nullable = false)
    String tipo;

    @Column(name = "marca", nullable = false)
    String marca;

    @Column(name = "color", nullable = false)
    String color;

    @Column(name = "talle", nullable = false)
    String talle;

    @Column(name = "cantidad", nullable = false)
    Integer cantidad;

    @Column(name = "precio_enta", nullable = false)
    Double precioVenta;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prendas_clientes", joinColumns = @JoinColumn(name = "prenda_id"), inverseJoinColumns = @JoinColumn(name = "clientes_id"))
    private Set<Cliente> clientes = new HashSet<>();
}
