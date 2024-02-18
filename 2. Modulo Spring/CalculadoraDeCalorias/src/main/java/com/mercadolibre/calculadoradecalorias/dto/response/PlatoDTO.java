package com.mercadolibre.calculadoradecalorias.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlatoDTO {
    int cantidadTotal;
    List<AlimentoDTO> alimentos;
    AlimentoDTO alimento_max_calorias;
}
