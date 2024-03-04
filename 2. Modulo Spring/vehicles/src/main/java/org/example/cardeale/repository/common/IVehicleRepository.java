package org.example.cardeale.repository.common;

import org.example.cardeale.entity.vehicle.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    Vehicle create(Vehicle vehicle);
    Vehicle getById(int id);
    List<Vehicle> getAll();
}
