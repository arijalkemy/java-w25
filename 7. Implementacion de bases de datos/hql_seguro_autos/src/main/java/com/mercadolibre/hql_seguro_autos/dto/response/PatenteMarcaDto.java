package com.mercadolibre.hql_seguro_autos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PatenteMarcaDto {
    private String patente;
    private String marca;
}
