package com.mercadolibre.w25.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AthleteDto {
    private String athleteName;
    private String athleteLastName;
    private String sportName;
}
