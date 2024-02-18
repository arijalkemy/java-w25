package com.mercadolibre.concesionariadeautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceFilterDTO {
    private Integer since;
    private Integer to;
}
