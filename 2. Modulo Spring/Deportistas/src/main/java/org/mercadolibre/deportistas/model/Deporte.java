package org.mercadolibre.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private int nivel;
}
