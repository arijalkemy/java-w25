package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> getVehicles();
    Vehicle getVehicleById(int id);
    int saveVehicle(Vehicle vehicle);
    List<Vehicle> getVehicleByDate(LocalDate since, LocalDate to);
    List<Vehicle> getVehicleByPrice(int since, int to);
}
