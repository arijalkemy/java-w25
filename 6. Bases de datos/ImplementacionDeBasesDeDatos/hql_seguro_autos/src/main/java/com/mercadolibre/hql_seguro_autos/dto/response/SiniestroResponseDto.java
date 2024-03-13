package com.mercadolibre.hql_seguro_autos.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.hql_seguro_autos.entity.Vehiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class SiniestroResponseDto {
    private  Long id;
    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;
    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
}
