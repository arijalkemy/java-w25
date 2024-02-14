package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.entity.Vehicle;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleWServiceDTO {
    private Integer id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;

    public VehicleWServiceDTO(Vehicle vehiculo) {
        this.id = vehiculo.getId();
        this.brand = vehiculo.getBrand();
        this.model = vehiculo.getModel();
        this.manufacturingDate = vehiculo.getManufacturingDate();
        this.numberOfKilometers = vehiculo.getNumberOfKilometers();
        this.doors = vehiculo.getDoors();
        this.price = vehiculo.getPrice();
        this.currency = vehiculo.getCurrency();
        this.countOfOwners = vehiculo.getCountOfOwners();
    }
}
