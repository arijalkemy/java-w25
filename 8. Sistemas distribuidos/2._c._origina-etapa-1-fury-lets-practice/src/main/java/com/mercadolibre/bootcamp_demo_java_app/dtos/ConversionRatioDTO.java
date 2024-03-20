package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionRatioDTO {
    @JsonProperty("ratio")
    private Double ratio;

    @JsonProperty("mercado_pago_ratio")
    private Double mercadoPagoRatio;
}
