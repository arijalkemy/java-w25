package com.vehiculos.ejercicio_vehiculos.repository;

import com.vehiculos.ejercicio_vehiculos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void create(Vehicle vehicle);
    List<Vehicle> findByColorAndYear(String color, Integer year);
    List<Vehicle> findByBrandAndRangeYears(String brand, Integer start_year, Integer end_year);
    List<Vehicle> findByBrand(String brand);
    Vehicle findById(Long id);
}
