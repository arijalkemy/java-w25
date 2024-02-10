package com.example.concesionario.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class VehicleNoServicesDTO {
    String id;
    String brand;
    String model;
    String manufacturingDate;
    String numberOfKilometers;
    String doors;
    String price;
    String currency;
    String countOfOwners;
}
