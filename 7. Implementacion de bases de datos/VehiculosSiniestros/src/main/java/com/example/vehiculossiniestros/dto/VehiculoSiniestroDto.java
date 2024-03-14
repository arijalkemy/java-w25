package com.example.vehiculossiniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoSiniestroDto {
  private PatenteMarcaModeloDto vehiculo;
  private Integer total_perdida;
}
