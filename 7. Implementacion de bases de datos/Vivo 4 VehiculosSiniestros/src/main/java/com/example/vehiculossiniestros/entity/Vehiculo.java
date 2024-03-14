package com.example.vehiculossiniestros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Vehiculo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String patente;
  private String marca;
  private String modelo;
  private LocalDate fecha_fabricacion;
  private Long cantidad_de_ruedas;
  @OneToMany(mappedBy = "vehiculo_denunciado", cascade = CascadeType.ALL)
  private Set<Siniestro> siniestros;
}
