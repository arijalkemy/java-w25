package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAverageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleSpeedDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto addVehicle(VehicleDto vehicle);

    List<VehicleDto> searchByColoryAnio(String color, int anio);

    List<VehicleDto> searchByBrandYears(String brand, int startYear, int endYear);

    VehicleAverageSpeedDto getAverageSpeedByBrand(String brand);

    List<VehicleDto> addVehiclesBatch(List<VehicleDto> vehicleDto);

    VehicleSpeedDto updateVehicleSpeed(Long id, double speed);

    List<VehicleDto> getVehiclesByFuelType(String fuel);

    String deleteVehicle(Long id);

    List<VehicleDto> getVehiclesByTransmissionType(String type);

    String updateVehicleFuelType(Long id, String fuel);

    VehicleAverageCapacityDto getAverageCapacityByBrand(String brand);

    List<VehicleDto>  getVehiclesByDimensions(Double minLength, Double maxLength, Double minWidth, Double maxWidth);


    List<VehicleDto> getVehiclesByWeight(Double weightMin, Double weightMax);
}
