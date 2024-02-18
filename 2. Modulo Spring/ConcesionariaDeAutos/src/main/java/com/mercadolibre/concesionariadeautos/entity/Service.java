package com.mercadolibre.concesionariadeautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Service {
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
