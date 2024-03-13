package com.bootcamp.LasPerlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelResponseDTO {
    @JsonProperty("number_identification")
    private Long numberIdentification;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    @JsonProperty("has_stone")
    private boolean hasStone;
    private boolean saleOrNot;
}
