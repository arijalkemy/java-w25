package com.implementacionbd.ejercicio.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vehiculos")
@Data
public class Vehiculo {

    public Vehiculo(String patente, String marca, LocalDate anyoFabricacion, Integer cantidadRuedas, String modelo) {
        this.patente = patente;
        this.marca = marca;
        this.anyoFabricacion = anyoFabricacion;
        this.cantidadRuedas = cantidadRuedas;
        this.modelo = modelo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "patente", nullable = false)
    private String patente;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "anyo_fabricacion", nullable = false)
    private LocalDate anyoFabricacion;

    @Column(name = "cantidad_ruedas", nullable = false)
    private Integer cantidadRuedas;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private List<Siniestro> siniestros;

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

}
