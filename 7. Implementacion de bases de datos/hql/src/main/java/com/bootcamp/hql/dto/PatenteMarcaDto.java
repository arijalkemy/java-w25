package com.bootcamp.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaDto {
    private String patente;
    private String marca;
}
