package bootcamp.concesionariadeautos.service;

import bootcamp.concesionariadeautos.dto.VehicleCreationDto;
import bootcamp.concesionariadeautos.dto.VehicleDto;
import bootcamp.concesionariadeautos.entity.Vehicle;
import bootcamp.concesionariadeautos.repository.IVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(VehicleCreationDto vehicle) {
        VehicleDto vehicleDto = VehicleDto.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufacturingDate(vehicle.getManufacturingDate())
                .numberOfKilometers(vehicle.getNumberOfKilometers())
                .doors(vehicle.getDoors())
                .price(vehicle.getPrice())
                .currency(vehicle.getCurrency())
                .countOfOwners(vehicle.getCountOfOwners())
                .build();
        Vehicle newVehicle = vehicleRepository.createVehicle(vehicleDto);

        // Crear y vincular servicios con vehiculo

        return newVehicle;
    }

    @Override
    public List<VehicleDto> getAll() {
        return vehicleRepository.getAll().stream().map(this::createVehicleDto).toList();
    }

    @Override
    public List<VehicleDto> getBetweenDates(String since, String to) {
        return vehicleRepository.getBetweenDates(since, to).stream().map(this::createVehicleDto).toList();
    }

    @Override
    public List<VehicleDto> getBetweenPrices(String since, String to) {
        return vehicleRepository.getBetweenPrices(since, to).stream().map(this::createVehicleDto).toList();
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.getById(id);
    }

    private VehicleDto createVehicleDto(Vehicle vehicle) {
        return VehicleDto.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufacturingDate(vehicle.getManufacturingDate())
                .numberOfKilometers(vehicle.getNumberOfKilometers())
                .doors(vehicle.getDoors())
                .price(vehicle.getPrice())
                .currency(vehicle.getCurrency())
                .countOfOwners(vehicle.getCountOfOwners())
                .build();
    }

}
