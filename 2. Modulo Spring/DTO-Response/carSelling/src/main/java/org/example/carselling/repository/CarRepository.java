package org.example.carselling.repository;

import org.example.carselling.dto.CarDTO;
import org.example.carselling.entity.Car;
import org.example.carselling.entity.Services;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository implements ICarRepository{
    private List<Car> carList = new ArrayList<>();
    @Override
    public List<Car> getAllVehicles() {
        return carList;
    }

    @Override
    public void saveNewCar(Car car) {
        if (!carList.contains(car)){
            car.setId(carList.size());
            carList.add(car);
            System.out.println("Carro creado y agregado con éxito");
        } else {
            System.out.println("El auto ya se encuentra registrado");
        }
    }

    @Override
    public Car getCarById(Integer id) {
        return carList.stream()
                .filter(x -> x.getId() == id).findFirst().orElse(null);
    }
}
