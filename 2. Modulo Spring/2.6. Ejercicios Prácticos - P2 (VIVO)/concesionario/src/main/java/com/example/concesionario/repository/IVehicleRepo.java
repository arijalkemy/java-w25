package com.example.concesionario.repository;

import com.example.concesionario.entity.Vehicle;

import java.util.List;

public interface IVehicleRepo {
    void saveVehicle(Vehicle vehicle);

    List<Vehicle> readVehicles();
}