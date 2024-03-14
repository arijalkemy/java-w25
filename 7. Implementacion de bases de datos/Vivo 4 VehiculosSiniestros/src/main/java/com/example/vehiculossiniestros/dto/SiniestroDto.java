package com.example.vehiculossiniestros.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SiniestroDto {
  private Long id;
  private LocalDate fecha_siniestro;
  private Double perdida_economica;
}
