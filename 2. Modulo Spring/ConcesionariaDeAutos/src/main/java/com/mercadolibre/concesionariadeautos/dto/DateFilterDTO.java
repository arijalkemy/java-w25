package com.mercadolibre.concesionariadeautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DateFilterDTO {
    private LocalDate since;
    private LocalDate to;
}
