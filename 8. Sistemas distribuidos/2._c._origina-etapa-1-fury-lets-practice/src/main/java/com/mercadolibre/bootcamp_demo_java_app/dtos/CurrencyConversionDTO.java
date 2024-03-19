package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionDTO {
    @JsonProperty("currency_base")
    private String currencyBase;

    @JsonProperty("currency_quote")
    private String currencyQuote;

    @JsonProperty("rate")
    private Double rate;

    @JsonProperty("inv_rate")
    private Double invRate;

}