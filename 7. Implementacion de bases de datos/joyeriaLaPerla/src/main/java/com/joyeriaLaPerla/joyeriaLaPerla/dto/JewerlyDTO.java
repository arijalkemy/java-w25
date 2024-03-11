package com.joyeriaLaPerla.joyeriaLaPerla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JewerlyDTO {
    private String name;
    private String material;
    private  double weight;
    private String particularity;
    private boolean hasStone;
    private boolean availableForSale;
}
