package com.springboot.concesionariaautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarServiceDTO {
    private String date;
    private String kilometers;
    private String description;
}
