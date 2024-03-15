package com.consultashql.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatentesMarcaDTO {
    String patente;
    String marca;
    Integer anio;
}
