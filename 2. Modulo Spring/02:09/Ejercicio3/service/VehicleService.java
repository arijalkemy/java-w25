package main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.VehicleDTO;
import main.dto.VehicleWServiceDTO;
import main.entity.Vehicle;
import main.repository.VehicleRepository;

@Service
public class VehicleService implements IVehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public void postVehicle(VehicleDTO vehicleDTO) {
        vehicleRepository.getVehicleList().add(new Vehicle(vehicleDTO));
    }

    @Override
    public List<VehicleWServiceDTO> getVehicles() {
        List<VehicleWServiceDTO> listAux = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.getVehicleList()) {
            listAux.add(new VehicleWServiceDTO(vehicle));
        }
        return listAux;
    }

    @Override
    public VehicleDTO getVehiclesById(Integer id) {
        for (Vehicle vehicle : vehicleRepository.getVehicleList()) {
            if (vehicle.getId() == id) {
                return new VehicleDTO(vehicle);
            }
        }
        return new VehicleDTO();
    }

    @Override
    public List<VehicleWServiceDTO> getVehiclesByPrice(Integer since, Integer to) {
        List<VehicleWServiceDTO> listAux = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.getVehicleList()) {
            if (Double.parseDouble(vehicle.getPrice()) >= since && Double.parseDouble(vehicle.getPrice()) <= to) {
                listAux.add(new VehicleWServiceDTO(vehicle));
            }
        }
        return listAux;
    }

}
