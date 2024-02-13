package com.mercadolibre.w25.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private String name;
    private String lastName;
    private int age;

}
