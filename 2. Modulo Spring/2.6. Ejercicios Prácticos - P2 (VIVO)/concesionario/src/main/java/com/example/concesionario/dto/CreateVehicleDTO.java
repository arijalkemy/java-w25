package com.example.concesionario.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class CreateVehicleDTO {
    String brand;
    String model;
    String manufacturingDate;
    String numberOfKilometers;
    String doors;
    String price;
    String currency;
    List<VehicleServiceDTO> services;
    String countOfOwners;
}
