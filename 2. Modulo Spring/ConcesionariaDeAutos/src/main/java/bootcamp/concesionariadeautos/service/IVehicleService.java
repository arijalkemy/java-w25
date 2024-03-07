package bootcamp.concesionariadeautos.service;

import bootcamp.concesionariadeautos.dto.VehicleCreationDto;
import bootcamp.concesionariadeautos.dto.VehicleDto;
import bootcamp.concesionariadeautos.entity.Vehicle;

import java.util.List;

public interface IVehicleService {

    Vehicle createVehicle(VehicleCreationDto vehicle);

    List<VehicleDto> getAll();

    List<VehicleDto> getBetweenDates(String since, String to);

    List<VehicleDto> getBetweenPrices(String since, String to);

    Vehicle getById(Long id);

}
