package com.bootcamp.clase9feb.calculadoraCalorias.dto.response;

import com.bootcamp.clase9feb.calculadoraCalorias.entities.Alimento;
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
