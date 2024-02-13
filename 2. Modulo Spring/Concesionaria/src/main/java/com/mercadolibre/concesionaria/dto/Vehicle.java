package com.mercadolibre.concesionaria.dto;

import com.mercadolibre.concesionaria.model.Car;
import com.mercadolibre.concesionaria.model.CarServices;
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
public class Vehicle {
    Integer id;
    String brand;
    String manufacturingDate;
    Integer numberOfKilometers;
    Integer doors;
    Integer price;
    String currency;
    Integer countOfOwners;
    List<CarServices> services;

    public Vehicle(Car car){
        this.id = car.getId();
        this.brand = car.getBrand();
        this.manufacturingDate = car.getManufacturingDate();
        this.numberOfKilometers = car.getNumberOfKilometers();
        this.doors = car.getDoors();
        this.price = car.getPrice();
        this.currency = car.getCurrency();
        this.countOfOwners = car.getCountOfOwners();
        this.services = car.getServices();
    }
}
