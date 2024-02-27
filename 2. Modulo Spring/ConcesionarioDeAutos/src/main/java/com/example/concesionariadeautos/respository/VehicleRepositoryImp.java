package com.example.concesionariadeautos.respository;

import com.example.concesionariadeautos.dto.VehicleDTO;
import com.example.concesionariadeautos.entity.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;

import java.util.ArrayList;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImp implements IVehicleRepository{

    private File file = new File("classpath:Data.json");

    @Override
    public void createVehicle(Vehicle vehicle) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Lee el contenido actual del archivo si existe
            List<Vehicle> vehicles = new ArrayList<>();
            if (file.exists()) {
                String fileContent = Files.readString(file.toPath());
                vehicles = mapper.readValue(fileContent, new TypeReference<List<Vehicle>>() {});
            }

            // Agrega el nuevo vehículo a la lista
            vehicles.add(vehicle);

            // Convierte la lista de vehículos a JSON
            String jsonStr = mapper.writeValueAsString(vehicles);

            // Escribe el JSON actualizado en el archivo
            Files.writeString(file.toPath(), jsonStr);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles = null;
        List<VehicleDTO> vehiclesFinal = null;
        try {
            vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {});
            System.out.println(vehicles);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        vehiclesFinal = vehicles.stream().map(vehicle ->
                new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners())
        ).collect(Collectors.toList()
        );
        return vehiclesFinal;
    }

    @Override
    public List<VehicleDTO> getVehiclesByCreatedDate(String initialDate, String finalDate) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles = null;
        List<VehicleDTO> vehiclesFinal = null;
        try {
            vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {});
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        vehiclesFinal = vehicles.stream().filter(vehicle -> vehicle.getManufacturingDate().compareTo(initialDate) >= 0 && vehicle.getManufacturingDate().compareTo(finalDate) <= 0).map(vehicle ->
                new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners())
        ).collect(Collectors.toList()
        );
        return vehiclesFinal;
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(String initialPrice, String finalPrice) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles = null;
        List<VehicleDTO> vehiclesFinal = null;
        try {
            vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {});
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        vehiclesFinal = vehicles.stream().filter(vehicle -> vehicle.getPrice().compareTo(initialPrice) >= 0 && vehicle.getPrice().compareTo(finalPrice) <= 0).map(vehicle ->
                new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners())
        ).collect(Collectors.toList()
        );
        return vehiclesFinal;
    }

    @Override
    public VehicleDTO getVehicleById(String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles = null;
        VehicleDTO vehicleFinal = null;
        try {
            vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {});
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        vehicleFinal = vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).map(vehicle ->
                new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners())
        ).findFirst().orElse(null);
        return vehicleFinal;
    }

}
