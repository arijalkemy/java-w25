package com.implementacionbd.ejercicio.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "siniestros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {

    public Siniestro(LocalDate fechaSiniestro, Double perdidaEconomica) {
        this.fechaSiniestro = fechaSiniestro;
        this.perdidaEconomica = perdidaEconomica;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha_siniestro", nullable = false)
    private LocalDate fechaSiniestro;

    @Column(name = "perdida_economica", nullable = false)
    private Double perdidaEconomica;

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
