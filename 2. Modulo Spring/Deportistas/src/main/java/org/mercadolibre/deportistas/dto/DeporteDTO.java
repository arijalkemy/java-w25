package org.mercadolibre.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DeporteDTO {
    private String nombre;
    private int nivel;
}