package bootcamp.service;

import bootcamp.dto.VehicleDto;
import bootcamp.dto.VehicleWithoutServiceDto;
import bootcamp.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    Boolean save(VehicleDto vehicleDto);
    List<VehicleWithoutServiceDto> find();
    VehicleDto find(Integer id);
    List<VehicleDto> find(Double since, Double to);
    List<VehicleDto> find(String since, String to);
}
