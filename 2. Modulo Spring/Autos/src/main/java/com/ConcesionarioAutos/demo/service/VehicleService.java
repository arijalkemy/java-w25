package com.ConcesionarioAutos.demo.service;

import com.ConcesionarioAutos.demo.dto.vehiclesDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private List<vehiclesDTO> vehicles = new ArrayList<>();

    public void addVehicle(vehiclesDTO vehicle) {
        vehicles.add(vehicle);
    }

    public List<vehiclesDTO> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    public List<vehiclesDTO> getVehiclesByManufactureDate(Date since, Date to) {
        return vehicles.stream()
                .filter(vehicle -> !vehicle.getManufactureDate().before(since) && !vehicle.getManufactureDate().after(to))
                .collect(Collectors.toList());
    }

    public List<vehiclesDTO> getVehiclesByPrice(Double since, Double to) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                .collect(Collectors.toList());
    }

    public vehiclesDTO getVehicleById(String id) {
    return vehicles.stream()
            .filter(vehicle -> vehicle.getBrand().equals(id))
            .findFirst()
            .orElseThrow(() -> new VehicleNotFoundException("Vehicle with id " + id + " not found"));
}

    public class VehicleNotFoundException extends RuntimeException {

        public VehicleNotFoundException(String message) {
            super(message);
        }
    }
}