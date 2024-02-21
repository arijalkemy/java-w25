package com.sfritz.concesionariaautos.repositories;

import java.util.List;

import com.sfritz.concesionariaautos.entities.Car;

public interface ICarRepository {

    void createVehicle(Car car);
    List<Car> getAllVehicles();
    Car getVehicleById(Long id);
}
