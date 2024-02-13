package com.daquito.concesionarioautosspring.services;

import com.daquito.concesionarioautosspring.entity.Vehicle;
import com.daquito.concesionarioautosspring.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService {

    VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle){
        vehicleRepository.add(vehicle);
        return vehicle;
    }

    public Vehicle getVehicle(int index){
        return vehicleRepository.get(index);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.getAll();
    }

    public List<Vehicle> getVehicleByDates(LocalDate since, LocalDate to){
        return vehicleRepository.getAll().stream().filter(v -> !v.getManufacturingDate().isBefore(since) && !v.getManufacturingDate().isAfter(to)).toList();
    }

    public List<Vehicle> getVehicleByPrice(double since, double to){
        return vehicleRepository.getAll().stream().filter(v -> v.getPrice() > since && v.getPrice() < to).toList();
    }
}
