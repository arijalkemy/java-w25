package com.example.vehiculossiniestros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Siniestro {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate fecha_siniestro;
  private Double perdida_economica;
  @ManyToOne
  @JoinColumn(name = "vehiculo_denunciado_id")
  private Vehiculo vehiculo_denunciado;
}
