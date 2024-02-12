package com.example.concesionaria.repository;

import com.example.concesionaria.entity.Vehicle;
import com.example.concesionaria.service.VehicleServiceImp;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImp implements IVehicleRepository {
  private List<Vehicle> vehicles;

  public VehicleRepositoryImp() {this.vehicles = new ArrayList<>();}

  @Override
  public void save(Vehicle v) {
    this.vehicles.add(v);
  }

  @Override
  public Optional<Vehicle> getById(int id) {
    return this.vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
  }

  @Override
  public List<Vehicle> getByDate(LocalDate since, LocalDate to) {
    return this.vehicles.stream().filter(vehicle ->
        (
            vehicle.getManufacturingDate().isEqual(since) || vehicle.getManufacturingDate().isAfter(since)
        ) && vehicle.getManufacturingDate().isBefore(to)
    ).toList();
  }

  @Override
  public List<Vehicle> getByPrice(double since, double to) {
    return this.vehicles.stream().filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to).toList();
  }

  @Override
  public List<Vehicle> getAll() {
    return this.vehicles;
  }

  public Integer getNextId() {
    return this.vehicles.size();
  }
}
