package com.example.concesionariadeautos.service;
import com.example.concesionariadeautos.dto.VehicleDTO;
import com.example.concesionariadeautos.entity.Vehicle;
import com.example.concesionariadeautos.respository.IVehicleRepository;
import com.example.concesionariadeautos.respository.VehicleRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImp implements IVehicleService {
    IVehicleRepository vehicleService;

    public VehicleServiceImp(VehicleRepositoryImp vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        return vehicleService.getVehicles();
    }

    @Override
    public List<VehicleDTO> getVehiclesByCreatedDate(String initialDate, String finalDate) {
        return vehicleService.getVehiclesByCreatedDate(initialDate, finalDate);
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(String initialPrice, String finalPrice) {
        return vehicleService.getVehiclesByPrice(initialPrice, finalPrice);
    }

    @Override
    public VehicleDTO getVehicleById(String id) {
        return vehicleService.getVehicleById(id);
    }
}
