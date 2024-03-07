package bootcamp.concesionariadeautos.repository;

import bootcamp.concesionariadeautos.dto.VehicleDto;
import bootcamp.concesionariadeautos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    Vehicle createVehicle(VehicleDto vehicle);

    List<Vehicle> getAll();

    List<Vehicle> getBetweenDates(String since, String to);

    List<Vehicle> getBetweenPrices(String since, String to);

    Vehicle getById(Long id);

}
