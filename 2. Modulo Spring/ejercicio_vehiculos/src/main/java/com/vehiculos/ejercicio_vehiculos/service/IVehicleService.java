package com.vehiculos.ejercicio_vehiculos.service;

import com.vehiculos.ejercicio_vehiculos.dto.AverageSpeedDto;
import com.vehiculos.ejercicio_vehiculos.dto.VehicleDto;
import com.vehiculos.ejercicio_vehiculos.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String createVehicle(VehicleDto vehicleDto);
    List<VehicleDto> searchVehiclesByColorAndYear(String color, Integer year);
    List<VehicleDto> searchVehiclesByBrandAndRangeYear(String brand, Integer start_year, Integer end_year);
    AverageSpeedDto getAverageSpeedByBrand(String brand);
    String deleteVehicle(Long id);
    String modifySpeed(Long id, String max_speed);
}
