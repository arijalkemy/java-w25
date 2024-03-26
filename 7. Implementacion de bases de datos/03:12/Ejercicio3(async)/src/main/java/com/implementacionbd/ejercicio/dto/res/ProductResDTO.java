package com.implementacionbd.ejercicio.dto.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResDTO {
    String id;

    String name;

    Integer amount;

    @JsonProperty("cost_price")
    Double costPrice;

    @JsonProperty("sale_price")
    Double salePrice;

}
