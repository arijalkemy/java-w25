package com.mercadolibre.concesionaria_de_autos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Service {
    private LocalDate date;
    private int kilometers;
    private String descriptions;
}
