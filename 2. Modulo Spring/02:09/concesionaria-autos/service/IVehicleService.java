package main.service;

import java.util.List;

import main.dto.VehicleDTO;
import main.dto.VehicleWServiceDTO;

public interface IVehicleService {
    public void postVehicle(VehicleDTO vehicleDTO);

    public List<VehicleWServiceDTO> getVehicles();

    public VehicleDTO getVehiclesById(Integer id);

    public List<VehicleWServiceDTO> getVehiclesByPrice(Integer since, Integer to);
}
