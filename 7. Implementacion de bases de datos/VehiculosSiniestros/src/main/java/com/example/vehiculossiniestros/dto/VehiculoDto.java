package com.example.vehiculossiniestros.dto;

import com.example.vehiculossiniestros.entity.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {
  private Long id;
  private String patente;
  private String marca;
  private String modelo;
  private LocalDate fecha_fabricacion;
  private Long cantidad_de_ruedas;
  private Set<SiniestroDto> siniestros;
}
