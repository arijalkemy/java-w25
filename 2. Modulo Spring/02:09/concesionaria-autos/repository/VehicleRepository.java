package main.repository;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.entity.Vehicle;

@Repository
public class VehicleRepository implements IVehicleRepository {
    private List<Vehicle> vehicleList;

    public VehicleRepository() {
        this.vehicleList = loadVehicles();
    }

    private List<Vehicle> loadVehicles() {
        File file = null;
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            file = ResourceUtils.getFile("src/main/java/main/repository/vehicle.json");
            ObjectMapper mapperJSON = new ObjectMapper();
            TypeReference<List<Vehicle>> typeRef = new TypeReference<>() {
            };
            vehicles = mapperJSON.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicles;

    }

    @Override
    public List<Vehicle> getVehicleList() {
        return this.vehicleList;
    }
}
