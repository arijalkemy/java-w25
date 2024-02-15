package bootcamp.dto;

import bootcamp.entity.Service;
import bootcamp.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleWithoutServiceDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;

    public VehicleWithoutServiceDto(Vehicle vehicle) {
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.manufacturingDate = vehicle.getManufacturingDate().toString();
        this.numberOfKilometers = vehicle.getNumberOfKilometers();
        this.doors = vehicle.getDoors();
        this.price = vehicle.getPrice();
        this.currency = vehicle.getCurrency();
        this.countOfOwners = vehicle.getCountOfOwners();

    }
}
