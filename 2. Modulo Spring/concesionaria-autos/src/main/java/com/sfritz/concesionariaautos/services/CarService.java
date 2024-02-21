package com.sfritz.concesionariaautos.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.sfritz.concesionariaautos.dtos.ServiceDto;
import com.sfritz.concesionariaautos.dtos.requests.RequestCarDto;
import com.sfritz.concesionariaautos.dtos.response.FullResponseCarDto;
import com.sfritz.concesionariaautos.dtos.response.ResponseCarDto;
import com.sfritz.concesionariaautos.entities.Car;
import com.sfritz.concesionariaautos.entities.Service;
import com.sfritz.concesionariaautos.repositories.CarRepository;
import com.sfritz.concesionariaautos.repositories.ICarRepository;

@org.springframework.stereotype.Service
public class CarService implements ICarService{

    private ICarRepository repository;

    public CarService(CarRepository repository){
        this.repository = repository;
    }

    @Override
    public void createVehicle(RequestCarDto request) {
        List<Service> services = request.getServices().stream().map(s -> new Service(s.getDate(),s.getKilometers(),s.getDescription())).collect(Collectors.toList());
        Car car = new Car(0L,request.getBrand(),request.getModel(),request.getManufacturingDate(),request.getNumberOfKilometers(),request.getDoors(),request.getPrice(),request.getCurrency(),services,request.getCountOfOwners());
        repository.createVehicle(car);
    }

    @Override
    public List<ResponseCarDto> getAllVehicles() {
        List<ResponseCarDto> responseCarDtos = repository.getAllVehicles().stream().map(c -> new ResponseCarDto(c.getId(),c.getBrand(),c.getModel(),c.getManufacturingDate(),c.getNumberOfKilometers(),c.getDoors(),c.getPrice(),c.getCurrency(),c.getCountOfOwners())).collect(Collectors.toList());
        return responseCarDtos;
    }

    @Override
    public List<FullResponseCarDto> getVehiclesFromManufacturingDate(Date since, Date to) {
        List<FullResponseCarDto> fullResponseCarDtos = repository.getAllVehicles().stream().filter(c -> c.getManufacturingDate().after(since) && c.getManufacturingDate().before(to)).map(c -> new FullResponseCarDto(c.getId(),c.getBrand(),c.getModel(),c.getManufacturingDate(),c.getNumberOfKilometers(),c.getDoors(),c.getPrice(),c.getCurrency(),c.getServices().stream().map(s -> new ServiceDto(s.getDate(),s.getKilometers(),s.getDescription())).collect(Collectors.toList()),c.getCountOfOwners())).collect(Collectors.toList());
        return fullResponseCarDtos;
    }

    @Override
    public List<FullResponseCarDto> getVehiclesFromPrices(Double since, Double to) {
        return repository.getAllVehicles().stream().filter(c -> c.getPrice()>=since && c.getPrice()<=to).map(c -> new FullResponseCarDto(c.getId(),c.getBrand(),c.getModel(),c.getManufacturingDate(),c.getNumberOfKilometers(),c.getDoors(),c.getPrice(),c.getCurrency(),c.getServices().stream().map(s -> new ServiceDto(s.getDate(),s.getKilometers(),s.getDescription())).collect(Collectors.toList()),c.getCountOfOwners())).collect(Collectors.toList());
    }

    @Override
    public FullResponseCarDto getVehicleById(Long id) {
        Car car = repository.getVehicleById(id);
        return new FullResponseCarDto(car.getId(),car.getBrand(),car.getModel(),car.getManufacturingDate(),car.getNumberOfKilometers(),car.getDoors(),car.getPrice(),car.getCurrency(),car.getServices().stream().map(s -> new ServiceDto(s.getDate(),s.getKilometers(),s.getDescription())).collect(Collectors.toList()),car.getCountOfOwners());
    }

}
