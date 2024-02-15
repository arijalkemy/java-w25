package bootcamp.repository;

import bootcamp.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {

    Boolean save(Vehicle vehicle);
    List<Vehicle> find();
    Vehicle find(Integer id);

}
