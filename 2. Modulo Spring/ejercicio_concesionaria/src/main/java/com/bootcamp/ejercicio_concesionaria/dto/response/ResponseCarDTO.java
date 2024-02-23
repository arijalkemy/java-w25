package com.bootcamp.ejercicio_concesionaria.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseCarDTO {
    String brand, model, currency;
    LocalDate manufacturingDate;
    int numberOfKilometers, doors, countOfOwners;
    double price;
}
