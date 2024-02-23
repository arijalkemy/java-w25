package com.bootcamp.ejercicio_concesionaria.dto.request;

import com.bootcamp.ejercicio_concesionaria.entity.Service;
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
public class RequestCarDTO {
    String brand, model, currency;
    LocalDate manufacturingDate;
    int numberOfKilometers, doors, countOfOwners;
    double price;
    List<Service> services;
}
