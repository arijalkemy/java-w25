package com.bootcamp.Calorias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestCaloriasDTO {
    private String name;
    private double peso;
}
