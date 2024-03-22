package com.vehiculos.ejercicio_vehiculos.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehiculos.ejercicio_vehiculos.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public void create(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, Integer year) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getYear().equals(year) && vehicle.getColor().equals(color))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByBrandAndRangeYears(String brand, Integer start_year, Integer end_year) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand) && vehicle.getYear()>=start_year && vehicle.getYear() <=end_year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public Vehicle findById(Long id) {
        return listOfVehicles.get(Math.toIntExact(id));
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;

        file = ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {
        });

        listOfVehicles = vehicles;
    }
}
