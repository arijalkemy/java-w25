package main.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.dto.ServiceDTO;
import main.dto.VehicleDTO;

@Data
@AllArgsConstructor
public class Vehicle {
    private static int contador = 0;
    private Integer id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public Vehicle() {
        this.id = ++Vehicle.contador;
    }

    public Vehicle(VehicleDTO vehicleDTO) {
        this.brand = vehicleDTO.getBrand();
        this.model = vehicleDTO.getModel();
        this.manufacturingDate = vehicleDTO.getManufacturingDate();
        this.numberOfKilometers = vehicleDTO.getNumberOfKilometers();
        this.doors = vehicleDTO.getDoors();
        this.price = vehicleDTO.getPrice();
        this.currency = vehicleDTO.getCurrency();
        this.countOfOwners = vehicleDTO.getCountOfOwners();
        List<Service> listAux = new ArrayList<>();
        for (ServiceDTO service : vehicleDTO.getServices()) {
            listAux.add(new Service(service));
        }
        this.services = listAux;
    }
}
