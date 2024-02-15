package bootcamp.repository;

import bootcamp.dto.VehicleWithoutServiceDto;
import bootcamp.entity.Service;
import bootcamp.entity.Vehicle;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleRepositoryImpl(){
        loadVehicles();
    }

    private void loadVehicles() {
this.vehicles.add(new Vehicle(1,
        "Chrevolet",
        "Corsa",
        LocalDate.of(2000, 11, 20),
        115000,
        5,
        90000.0,
        "AR",
        List.of(
                new Service(
                        LocalDate.of(2003, 5, 20),
                        6000,
                        "Change of air Filter")),
        2));
    }


    @Override
    public Boolean save(Vehicle vehicle) {
        if(this.vehicles == null) {
            this.vehicles = new ArrayList<>();
        }
    this.vehicles.add(vehicle);
        return true;
    }

    @Override
    public List<Vehicle> find() {

        return this.vehicles;
    }

    @Override
    public Vehicle find(Integer id) {
        Optional<Vehicle> opt = this.vehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
        if (opt.isPresent()) return opt.get();
        return null;
    }
}
