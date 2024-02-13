package com.mercadolibre.concesionaria.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    Integer id;
    String brand;
    String manufacturingDate;
    Integer numberOfKilometers;
    Integer doors;
    Integer price;
    String currency;
    Integer countOfOwners;
    List<CarServices> services;

}
