package com.mercadolibre.concesionariadeautos.repository;

import com.mercadolibre.concesionariadeautos.entity.Vehicle;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class VehicleRepositoryImp implements IVehicleRepository {
    List<Vehicle> vehicles;

    @Override
    public Integer addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle.getId();
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicles.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
