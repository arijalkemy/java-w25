package com.springboot.concesionariaautos.repository.impl;

import com.springboot.concesionariaautos.entity.Car;
import com.springboot.concesionariaautos.entity.CarService;
import com.springboot.concesionariaautos.repository.IDealershipRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DealershipRepositoryImpl implements IDealershipRepository {
    private final List<Car> carsList = new ArrayList<>(List.of(
            new Car(1L, "Chevrolet", "Avalanche", "2024-01-25", "1050", "4", "26800", "USD", null, "1"),
            new Car(2L, "Volkswagen", "Amarok", "2022-05-01", "15000", "4", "20000", "USD",
                    List.of(new CarService("2022-08-10", "3000", "First service."),
                            new CarService("2022-10-10", "5000", "Second service."),
                            new CarService("2023-02-08", "10000", "Third service. Oil and filters were changed. Wheels rotation.")), "1"),
            new Car(3L, "Ram", "1500", "2021-10-22", "50000", "4", "22000", "USD",
                    List.of(new CarService("2021-12-08", "3000", "First service."),
                            new CarService("2022-03-10", "5000", "Second service.")), "2"),
            new Car(4L, "Toyota", "Hilux", "2023-10-22", "10000", "4", "15000", "USD",
                    List.of(new CarService("2021-12-08", "3000", "First service."),
                            new CarService("2022-03-10", "5000", "Second service.")), "2")
    ));

    @Override
    public void createCar(Car car) {
        carsList.add(car);
    }

    @Override
    public List<Car> getCars() {
        return carsList;
    }
}
