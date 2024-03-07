package bootcamp.concesionariadeautos.repository;

import bootcamp.concesionariadeautos.dto.VehicleDto;
import bootcamp.concesionariadeautos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Long index = 0L;
    @Override
    public Vehicle createVehicle(VehicleDto vehicle) {
        Vehicle newVehicle = Vehicle.builder()
                .id(index)
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufacturingDate(vehicle.getManufacturingDate())
                .numberOfKilometers(vehicle.getNumberOfKilometers())
                .doors(vehicle.getDoors())
                .price(vehicle.getPrice())
                .currency(vehicle.getCurrency())
                .countOfOwners(vehicle.getCountOfOwners())
                .build();
        index++;

        vehicles.add(newVehicle);

        return newVehicle;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> getBetweenDates(String since, String to) {
        LocalDate dateSince = LocalDate.parse(since);
        LocalDate dateTo = LocalDate.parse(to);

        return vehicles.stream().filter(v -> {
            boolean isAfterSince = LocalDate.parse(v.getManufacturingDate()).isAfter(dateSince);
            boolean isBeforeTo = LocalDate.parse(v.getManufacturingDate()).isBefore(dateTo);

            return isAfterSince && isBeforeTo;
        }).toList();
    }

    @Override
    public List<Vehicle> getBetweenPrices(String since, String to) {
        return vehicles.stream().filter(v ->
                Double.parseDouble(v.getPrice()) > Double.parseDouble(since) && Double.parseDouble(v.getPrice()) < Double.parseDouble(to))
                .toList();
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicles.get(id.intValue());
    }
}
