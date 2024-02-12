package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{
    List<Vehicle> vehicles;

    public VehicleRepositoryImpl() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        Optional<Vehicle> vehicleById = this.vehicles.stream().filter(vehicle -> vehicle.getId() == id).findFirst();
        return vehicleById.orElse(null);
    }

    @Override
    public int saveVehicle(Vehicle vehicle) {
            vehicle.setId(this.vehicles.size());
            vehicles.add(vehicle);
            return vehicle.getId();
    }

    @Override
    public List<Vehicle> getVehicleByDate(LocalDate since, LocalDate to) {
        return this.vehicles.stream()
                .filter(vehicle ->
                        vehicle.getManufacturingDate().isBefore(to)
                                && vehicle.getManufacturingDate().isAfter(since)).toList();
    }

    @Override
    public List<Vehicle> getVehicleByPrice(int since, int to) {
        return this.vehicles.stream().filter(vehicle -> vehicle.getPrice() > since && vehicle.getPrice() < to).toList();
    }


}
