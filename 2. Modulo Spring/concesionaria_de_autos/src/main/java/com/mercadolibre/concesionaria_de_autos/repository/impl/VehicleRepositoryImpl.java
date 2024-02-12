package com.mercadolibre.concesionaria_de_autos.repository.impl;

import com.mercadolibre.concesionaria_de_autos.model.Service;
import com.mercadolibre.concesionaria_de_autos.model.Vehicle;
import com.mercadolibre.concesionaria_de_autos.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class VehicleRepositoryImpl implements CrudRepository<Vehicle> {
    private final List<Vehicle> vehicles;
    private VehicleRepositoryImpl() {
        this.vehicles = new ArrayList<>(
                List.of(
                        Vehicle.builder()
                                .id(1L)
                                .brand("Ford")
                                .model("Fiesta")
                                .manufacturingDate(LocalDate.of(2010, 1, 1))
                                .numberOfKilometers(100000).doors(4).price(10000)
                                .currency("ARS")
                                .services(List.of(new Service(LocalDate.of(2013, 1, 1), 20000, "Cambio de aceite")))
                                .countOfOwners(1).build()
                )
        );
    }
    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setId((long) vehicles.size() + 1);
        vehicles.add(vehicle);
        return vehicle;
    }
    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
    }
    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }
}
