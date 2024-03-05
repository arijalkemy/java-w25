package com.bootcamp.concesionario.repository;

import com.bootcamp.concesionario.dto.MessageDto;
import com.bootcamp.concesionario.dto.VehicleDto;
import com.bootcamp.concesionario.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    MessageDto saveVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getByIdVehicle(int idVehicle);

}
