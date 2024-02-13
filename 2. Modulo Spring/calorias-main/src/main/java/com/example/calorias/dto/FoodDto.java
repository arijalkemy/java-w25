package com.example.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FoodDto {
    private String name;
    private Integer calories;
}
