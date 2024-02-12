package com.example.concesionaria.repository;

import com.example.concesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
  void save(Vehicle v);
  Optional<Vehicle> getById(int id);
  List<Vehicle> getByDate(LocalDate since, LocalDate to);
  List<Vehicle> getByPrice(double since, double to);
  List<Vehicle> getAll();
  Integer getNextId();
}
