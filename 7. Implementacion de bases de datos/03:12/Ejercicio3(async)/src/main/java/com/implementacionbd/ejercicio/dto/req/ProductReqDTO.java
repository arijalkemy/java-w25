package com.implementacionbd.ejercicio.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductReqDTO {

    String name;

    Integer amount;

    @JsonProperty("cost_price")
    Double costPrice;

    @JsonProperty("sale_price")
    Double salePrice;

}
