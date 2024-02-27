package com.example.concesionariadeautos.service;

import com.example.concesionariadeautos.dto.VehicleDTO;
import com.example.concesionariadeautos.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    void createVehicle(Vehicle vehicle);
    List<VehicleDTO> getVehicles();
    List<VehicleDTO> getVehiclesByCreatedDate(String initialDate, String finalDate);
    List<VehicleDTO> getVehiclesByPrice(String initialPrice, String finalPrice);
    VehicleDTO getVehicleById(String id);
}
