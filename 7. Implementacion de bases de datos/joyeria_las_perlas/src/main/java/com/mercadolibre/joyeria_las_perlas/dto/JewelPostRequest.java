package com.mercadolibre.joyeria_las_perlas.dto;

import lombok.Data;
@Data
public class JewelPostRequest {
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private Boolean hasStone;
    private Boolean isOnSale;
}
