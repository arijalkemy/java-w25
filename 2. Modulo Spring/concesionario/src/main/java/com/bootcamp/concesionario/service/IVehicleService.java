package com.bootcamp.concesionario.service;

import com.bootcamp.concesionario.dto.MessageDto;
import com.bootcamp.concesionario.dto.VehicleDto;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    MessageDto addVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getAllVehicles();
    List<VehicleDto> getAllVehiclesByProductionDate(LocalDate sinceDate, LocalDate toDate);
    List<VehicleDto> getAllVehiclesByPrice(double sincePrice, double toPrice);
    VehicleDto getByIdVehicle(int idVehicle);

}
