package com.springlh.ejercicios0902.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateCaloriesDTO {
    private String name;
    private Integer calories;
}
