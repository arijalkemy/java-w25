package com.example.AutosPedrosa.services;

import com.example.AutosPedrosa.models.Car;
import com.example.AutosPedrosa.models.CarDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehiclesServicesImpl implements IVehiclesService{

    private Map<Long, Car> cars = new HashMap<>();

    private Long id;

    @PostConstruct
    private void postConstruct() {
        this.id = 1L;
    }

    @Override
    public boolean addCar(Car car) {
        this.cars.put(id,car);
        this.id += 1;
        return true;
    }

    @Override
    public List<CarDTO> getCars() {
        return cars.entrySet().stream().map(x -> getCarDTO(x.getValue())).collect(Collectors.toList());
    }

    private CarDTO getCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setCurrency(car.getCurrency());
        carDTO.setDoors(car.getDoors());
        carDTO.setModel(car.getModel());
        carDTO.setCountOfOwners(car.getCountOfOwners());
        carDTO.setManufacturingDate(car.getManufacturingDate());
        carDTO.setNumberOfKilometers(car.getNumberOfKilometers());
        carDTO.setPrice(car.getPrice());
        carDTO.setServices(car.getServices());

        carDTO.setId(this.id -1);


        return carDTO;
    }

    @Override
    public List<Car> getCarsBetweenDates(Date since, Date to) {
        return null;
    }

    @Override
    public List<Car> getCarsBetweenPrices(Double since, Double to) {
        return null;
    }

    @Override
    public Car getCar(Long id) {
        return cars.get(id);
    }
}
