package com.mercadolibre.concesionariadeautos.repository;

import com.mercadolibre.concesionariadeautos.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {
    Integer addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Integer id);
}
