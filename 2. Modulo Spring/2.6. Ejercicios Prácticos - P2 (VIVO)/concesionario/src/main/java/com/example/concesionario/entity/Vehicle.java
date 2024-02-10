package com.example.concesionario.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Vehicle {
    static Integer nextId = 1;

    Integer id;
    String brand;
    String model;
    LocalDate manufacturingDate;
    Integer numberOfKilometers;
    Integer doors;
    Integer price;
    String currency;
    List<VehicleService> services;
    Integer countOfOwners;

    public Vehicle(String brand, String model, LocalDate manufacturingDate, Integer numberOfKilometers, Integer doors, Integer price, String currency, List<VehicleService> services, Integer countOfOwners) {
        this.id = nextId++;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
