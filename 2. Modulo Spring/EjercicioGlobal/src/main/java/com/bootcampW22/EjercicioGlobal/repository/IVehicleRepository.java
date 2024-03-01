package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.io.IOException;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle save(Vehicle vehicle);
    Vehicle findById(Long id);
    List<Vehicle> findByColorAndYear(String color,Integer year);
    List<Vehicle> findByBrandAndBetweenYears(String brand,Integer startYear,Integer endYear);
    List<Vehicle>findByBrand(String brand);
    Boolean save(List<Vehicle> vehicles);
    Boolean updateSpeed(Long id ,String speed) throws IOException;
    Boolean deletedById(Long id);
}
