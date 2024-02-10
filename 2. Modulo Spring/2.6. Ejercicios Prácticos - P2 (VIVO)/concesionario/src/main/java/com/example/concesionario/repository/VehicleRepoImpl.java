package com.example.concesionario.repository;

import com.example.concesionario.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepoImpl implements IVehicleRepo {
    private static List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> readVehicles() {
        return vehicles;
    }
}
