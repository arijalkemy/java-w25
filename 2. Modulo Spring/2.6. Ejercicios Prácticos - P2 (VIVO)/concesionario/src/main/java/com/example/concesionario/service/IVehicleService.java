package com.example.concesionario.service;

import com.example.concesionario.dto.CreateVehicleDTO;
import com.example.concesionario.dto.VehicleDTO;
import com.example.concesionario.dto.VehicleNoServicesDTO;

import java.util.List;

public interface IVehicleService {
    void createVehicle(CreateVehicleDTO createVehicleDTO);

    List<VehicleNoServicesDTO> getVehicles();

    List<VehicleNoServicesDTO> getVehiclesByDate(String sinceDate, String toDate);

    List<VehicleNoServicesDTO> getVehiclesByPrice(String sincePrice, String toPrice);

    VehicleDTO getVehicleById(String id);
}
