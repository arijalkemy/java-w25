package com.example.concesionaria.service;

import com.example.concesionaria.dto.request.VehicleDTO;
import com.example.concesionaria.dto.response.CompleteVehicleDTO;
import com.example.concesionaria.dto.response.SaveDTO;
import com.example.concesionaria.dto.response.VehicleResponseDTO;
import com.example.concesionaria.entity.ServiceE;
import com.example.concesionaria.entity.Vehicle;
import com.example.concesionaria.repository.IVehicleRepository;
import com.example.concesionaria.repository.VehicleRepositoryImp;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleServiceImp implements IVehicleService {
  private IVehicleRepository repository;
  public VehicleServiceImp(VehicleRepositoryImp vehicleRepository) { this.repository = vehicleRepository; }

  @Override
  public SaveDTO save(VehicleDTO vehicle) {
    Vehicle vehicleToSave = new Vehicle();
    vehicleToSave.setBrand(vehicle.getBrand());
    vehicleToSave.setModel(vehicle.getModel());
    vehicleToSave.setManufacturingDate(LocalDate.parse(vehicle.getManufacturingDate()));
    vehicleToSave.setNumberOfKilometers(Integer.parseInt(vehicle.getNumberOfKilometers()));
    vehicleToSave.setDoors(Integer.parseInt(vehicle.getDoors()));
    vehicleToSave.setPrice(Double.parseDouble(vehicle.getPrice()));
    vehicleToSave.setCurrency(vehicle.getCurrency());
    vehicleToSave.setCountOfOwners(Integer.parseInt(vehicle.getCountOfOwners()));
    vehicleToSave.setServices(
        vehicle.getServices().stream().map(
            s -> new ServiceE(LocalDate.parse(s.getDate()), Integer.parseInt(s.getKilometers()), s.getDescriptions())
        ).toList()
    );

    vehicleToSave.setId(repository.getNextId());
    repository.save(vehicleToSave);

    return new SaveDTO(vehicleToSave.getId());
  }

  @Override
  public List<VehicleResponseDTO> getAll() {
    List<Vehicle> vehicles = repository.getAll();

    return vehicles.stream().map(VehicleResponseDTO::new).toList();
  }

  @Override
  public CompleteVehicleDTO getById(String id) {
    Optional<Vehicle> vehicleOptional = repository.getById(Integer.parseInt(id));

    return vehicleOptional.map(CompleteVehicleDTO::new).orElseGet(CompleteVehicleDTO::new);
  }
}
