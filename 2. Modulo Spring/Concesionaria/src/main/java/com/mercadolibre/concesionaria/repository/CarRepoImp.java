package com.mercadolibre.concesionaria.repository;

import com.mercadolibre.concesionaria.model.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepoImp implements ICRUD<Car,Integer>{

    private List<Car> carList;
    private Integer idCpunter;

    public CarRepoImp(){
        this.carList = new ArrayList<>();

    }
    @Override
    public List<Car> getAll() {
        return this.carList;
    }

    @Override
    public List<Car> getByDates(String since, String to) {
        return this.carList.stream().filter(car -> isDateBetween(car.getManufacturingDate(),since,to)).toList();
    }

    @Override
    public List<Car> getByPrices(Integer since, Integer to) {
        return this.carList.stream().filter(car -> car.getPrice()>= since && car.getPrice()<= to).toList();
    }

    @Override
    public Car getById(Integer id) {
        return this.carList.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(new Car());
    }

    @Override
    public void add(Car car) {
        this.carList.add(car);
    }

    private boolean isDateBetween(String date, String since, String to){
        LocalDate localDate= LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDateSince = LocalDate.parse(since, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDateTo = LocalDate.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return  localDate.isBefore(localDateTo) && localDate.isAfter(localDateSince);
    }
}
