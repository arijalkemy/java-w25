package org.example.cardeale.repository.impl;

import org.example.cardeale.entity.vehicle.Vehicle;
import org.example.cardeale.repository.common.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private List<Vehicle> dataSource;

    public VehicleRepositoryImpl(){
        this.dataSource = new ArrayList<>();
    }
    @Override
    public Vehicle create(Vehicle vehicle) {
        this.dataSource.add(vehicle);
        return vehicle;
     }

    @Override
    public Vehicle getById(int id) {
        return this.dataSource.get(id);
    }

    @Override
    public List<Vehicle> getAll() {
        return this.dataSource;
    }
}
