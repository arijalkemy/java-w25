package com.mercadolibre.hql_seguro_autos.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PerdidaEconomicaDto {
    private PatenteMarcaModeloDto vehiculo;
    @JsonProperty("perdida_total")
    private Double perdidaTotal;
}
