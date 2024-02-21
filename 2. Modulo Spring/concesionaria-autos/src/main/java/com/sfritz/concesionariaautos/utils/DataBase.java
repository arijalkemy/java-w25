package com.sfritz.concesionariaautos.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sfritz.concesionariaautos.entities.Car;

@Component
public class DataBase {

    private static Long idCarsGenerator = 0L;
    private List<Car> cars;

    public DataBase(){
        this.cars = new ArrayList<>();
    }

    public void createVehicle(Car car){
        car.setId(++idCarsGenerator);
        this.cars.add(car);
    }

    public List<Car> getAllVehicles(){
        return this.cars;
    }

    public Car getVehicleById(Long id){
        return this.cars.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow();
    }
}
