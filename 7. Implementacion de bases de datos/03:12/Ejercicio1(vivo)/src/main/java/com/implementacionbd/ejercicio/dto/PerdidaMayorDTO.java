package com.implementacionbd.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerdidaMayorDTO {
    private List<MatriculaMarcaModeloDTO> perdidaMayorA10000;
}
