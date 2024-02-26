package com.bootcamp.ejercicio_concesionaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @JsonIgnore
    int id;
    String brand, model, currency;
    LocalDate manufacturingDate;
    int numberOfKilometers, doors, countOfOwners;
    double price;
    @JsonIgnore
    List<Service> services;
}
