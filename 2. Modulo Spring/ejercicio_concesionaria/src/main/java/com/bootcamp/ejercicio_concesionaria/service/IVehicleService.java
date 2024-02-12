package com.bootcamp.ejercicio_concesionaria.service;

import com.bootcamp.ejercicio_concesionaria.dto.request.VehicleDTO;
import com.bootcamp.ejercicio_concesionaria.dto.response.VehicleWithoutServiceDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    int addVehicle(VehicleDTO vehicleDto);
    List<VehicleWithoutServiceDTO> getVehicles();
    VehicleWithoutServiceDTO getVehicleById(int id);
List<VehicleWithoutServiceDTO> getVehicleByDate(LocalDate since, LocalDate to);
    List<VehicleWithoutServiceDTO> getVehicleByPrice(int since, int to);
}
