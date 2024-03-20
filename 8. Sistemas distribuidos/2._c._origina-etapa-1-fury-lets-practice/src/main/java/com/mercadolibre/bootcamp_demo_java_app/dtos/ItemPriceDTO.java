package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPriceDTO {

    @JsonProperty("title")
    String title;

    @JsonProperty("price")
    Double price;

    @JsonProperty("currency_id")
    private CurrencyEnum currencyId;
}
