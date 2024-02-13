package com.mercadolibre.concesionaria.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.concesionaria.dto.Vehicle;
import com.mercadolibre.concesionaria.model.Car;
import com.mercadolibre.concesionaria.repository.CarRepoImp;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private CarRepoImp carRepo;
    private Integer idCounter;

    public VehicleService(CarRepoImp carRepo) {
        this.carRepo = carRepo;
        this.idCounter=0;
    }


    public void addVehicle(Vehicle vehicle){
        Car car = new Car(this.idCounter,
                vehicle.getBrand(),
                vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners(),
                vehicle.getServices());
        this.carRepo.add(car);
        this.idCounter++;
    }

    public List<Vehicle> getAll(){

        ObjectMapper mapper= new ObjectMapper();
        return mapper.convertValue(this.carRepo.getAll(), new TypeReference<List<Vehicle>>() { });
    }

    public List<Vehicle> getByPrice(Integer since, Integer to){
        ObjectMapper mapper= new ObjectMapper();
        return mapper.convertValue(this.carRepo.getByPrices(since, to), new TypeReference<List<Vehicle>>() { });
    }

    public List<Vehicle> getByDate(String since, String to){
        ObjectMapper mapper= new ObjectMapper();
        return mapper.convertValue(this.carRepo.getByDates(since, to), new TypeReference<List<Vehicle>>() { });
    }
    public Vehicle getById(Integer id){
        ObjectMapper mapper= new ObjectMapper();
        return mapper.convertValue(this.carRepo.getById(id), new TypeReference<Vehicle>() { });
    }
}
