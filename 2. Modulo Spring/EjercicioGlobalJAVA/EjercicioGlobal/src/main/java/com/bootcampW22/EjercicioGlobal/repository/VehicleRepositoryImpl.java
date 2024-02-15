package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
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
    public Vehicle save(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Boolean exist(long id) {
        return listOfVehicles.stream().anyMatch(v -> v.getId().equals(id));

    }

    @Override
    public List<Vehicle> searchByColoryAnio(String color, int anio) {
        return listOfVehicles.stream().filter(v -> v.getYear().equals(anio)).filter(v -> v.getColor().equals(color)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByBrandAndYears(String brand, int startYear, int endYear) {
        return listOfVehicles.stream().filter(v -> v.getBrand().equalsIgnoreCase(brand)).filter(v -> v.getYear() >= startYear).filter(v -> v.getYear() <= endYear).toList();
    }

    @Override
    public double getAverageSpeedByBrand(String brand) {

        OptionalDouble averageSpeed = listOfVehicles.stream().filter(v -> v.getBrand().equalsIgnoreCase(brand)).mapToDouble(v -> Double.parseDouble(v.getMax_speed())).average();

        if (averageSpeed.isPresent()) {
            return averageSpeed.getAsDouble();
        } else {
            return 0.00;
        }

    }

    @Override
    public double updateVehicleSpeed(Long id, double speed) {
        Optional<Vehicle> vehicle = listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
        if (vehicle.isPresent()) {
            vehicle.get().setMax_speed(String.valueOf(speed));
        } else {
            throw new NotFoundException("No se encontro el vehiculo");
        }
        return speed;
    }

    @Override
    public List<Vehicle> getVehiclesByFuelType(String fuel) {
       return listOfVehicles.stream().filter(v -> v.getFuel_type().equalsIgnoreCase(fuel)).toList();

    }

    @Override
    public boolean deleteVehicle(Long id) {
       Optional<Vehicle> vehicle = listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
       if(vehicle.isPresent()){
           listOfVehicles.remove(vehicle.get());
           return true;
       }else{
           return false;
       }
    }

    @Override
    public List<Vehicle> getVehiclesByTransmissionType(String type) {
       return listOfVehicles.stream().filter(v -> v.getTransmission().equalsIgnoreCase(type)).toList();
    }

    @Override
    public boolean updateVehicleFuelType(Long id, String fuel) {
        Optional<Vehicle> vehicle = listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
        if(vehicle.isPresent()){
            vehicle.get().setFuel_type(fuel);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double getAverageCapacityByBrand(String brand) {

        OptionalDouble averageCapacity = listOfVehicles.stream().filter(v -> v.getBrand().equalsIgnoreCase(brand)).mapToDouble(v-> v.getPassengers()).average();
        if(averageCapacity.isPresent()){
            return averageCapacity.getAsDouble();
        }else{
            return 0;
        }

    }

    @Override
    public List<Vehicle> getVehiclesByDimensions(Double minLength, Double maxLength, Double minWidth, Double maxWidth) {
        return listOfVehicles.stream().filter(v -> v.getLength() <= maxLength && v.getLength() >= minLength && v.getWidth()>= minWidth && v.getWidth()<= maxWidth).toList();
    }

    @Override
    public List<Vehicle> getVehiclesByWeight(Double weightMin, Double weightMax) {
        return listOfVehicles.stream().filter(v -> v.getWeight() <= weightMax && v.getWeight() >= weightMin).toList();
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
