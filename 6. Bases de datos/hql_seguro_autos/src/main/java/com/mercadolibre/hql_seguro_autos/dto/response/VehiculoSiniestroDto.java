package com.mercadolibre.hql_seguro_autos.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class VehiculoSiniestroDto {
    @JsonProperty("perdidas_economicas")
    private List<PerdidaEconomicaDto> perdidasEconomicas;
}
