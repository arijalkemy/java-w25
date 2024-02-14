package main.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.entity.Service;
import main.entity.Vehicle;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Integer id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<ServiceDTO> services;
    private String countOfOwners;

    public VehicleDTO(Vehicle vehiculo) {
        this.id = vehiculo.getId();
        this.brand = vehiculo.getBrand();
        this.model = vehiculo.getModel();
        this.manufacturingDate = vehiculo.getManufacturingDate();
        this.numberOfKilometers = vehiculo.getNumberOfKilometers();
        this.doors = vehiculo.getDoors();
        this.price = vehiculo.getPrice();
        this.currency = vehiculo.getCurrency();
        this.countOfOwners = vehiculo.getCountOfOwners();
        List<ServiceDTO> listAux = new ArrayList<>();
        for (Service service : vehiculo.getServices()) {
            listAux.add(new ServiceDTO(service));
        }
        this.services = listAux;
    }
}
