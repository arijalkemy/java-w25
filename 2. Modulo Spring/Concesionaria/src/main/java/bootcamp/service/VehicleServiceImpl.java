package bootcamp.service;

import bootcamp.dto.VehicleDto;
import bootcamp.dto.VehicleWithoutServiceDto;
import bootcamp.entity.Vehicle;
import bootcamp.repository.VehicleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired private VehicleRepositoryImpl repo;
    @Override
    public Boolean save(VehicleDto vehicleDto) {
        int[] dateArray = Arrays.stream(vehicleDto.getManufacturingDate().split("-"))
                .mapToInt(Integer::valueOf).toArray();
        LocalDate date = LocalDate.of(dateArray[0], dateArray[1], dateArray[2]);
        Vehicle vehicle = new Vehicle(
                vehicleDto.getBrand(),
                vehicleDto.getModel(),
                date,
                vehicleDto.getNumberOfKilometers(),
                vehicleDto.getDoors(),
                vehicleDto.getPrice(),
                vehicleDto.getCurrency(),
                vehicleDto.getServices(),
                vehicleDto.getCountOfOwners()
        );
        return repo.save(vehicle);
    }

    @Override
    public List<VehicleWithoutServiceDto> find() {
        return this.repo.find().stream().map(VehicleWithoutServiceDto::new).toList();
    }

    @Override
    public VehicleDto find(Integer id) {
        Vehicle v = this.repo.find(id);
        if(v == null) return null;
        return new VehicleDto(v);
    }

    public List<VehicleDto> find(Double since, Double to) {
       return repo.find().stream().filter(vehicle -> vehicle.getPrice() >= since)
                .filter(vehicle ->  vehicle.getPrice() <= to)
               .map(VehicleDto::new)
        .toList();
    }
    public List<VehicleDto> find(String since, String to) {
        int[] dateArraySince = Arrays.stream(since.split("-"))
                .mapToInt(Integer::valueOf).toArray();
        LocalDate dateSince = LocalDate.of(dateArraySince[0], dateArraySince[1], dateArraySince[2]);
        int[] dateArrayTo = Arrays.stream(to.split("-"))
                .mapToInt(Integer::valueOf).toArray();
        LocalDate dateTo = LocalDate.of(dateArrayTo[0], dateArrayTo[1], dateArrayTo[2]);

       return repo.find().stream().filter(vehicle ->
                       vehicle.getManufacturingDate().isAfter(dateSince))
                .filter(vehicle ->
                        vehicle.getManufacturingDate().isBefore(dateTo))
               .map(VehicleDto::new)
        .toList();
    }
}
