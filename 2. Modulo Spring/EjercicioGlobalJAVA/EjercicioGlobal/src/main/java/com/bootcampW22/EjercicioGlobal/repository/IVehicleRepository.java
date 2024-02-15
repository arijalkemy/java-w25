package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle save(Vehicle vehicle);
    Boolean exist(long id);

    List<Vehicle> searchByColoryAnio(String color, int anio);

    List<Vehicle> findByBrandAndYears(String brand, int startYear, int endYear);

    double getAverageSpeedByBrand(String brand);

    double updateVehicleSpeed(Long id, double speed);

    List<Vehicle> getVehiclesByFuelType(String fuel);

    boolean deleteVehicle(Long id);

    List<Vehicle> getVehiclesByTransmissionType(String type);

    boolean updateVehicleFuelType(Long id, String fuel);

    double getAverageCapacityByBrand(String brand);

    List<Vehicle> getVehiclesByDimensions(Double minLength, Double maxLength, Double minWidth, Double maxWidth);

    List<Vehicle> getVehiclesByWeight(Double weightMin, Double weightMax);
}
