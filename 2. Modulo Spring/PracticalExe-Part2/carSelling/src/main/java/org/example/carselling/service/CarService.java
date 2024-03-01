package org.example.carselling.service;

import org.example.carselling.dto.CarDTO;
import org.example.carselling.entity.Car;
import org.example.carselling.entity.Services;
import org.example.carselling.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarService implements ICarService{
    @Autowired
    CarRepository carRepository;

    @Override
    public void createCar(CarDTO carDTO) {
        List<Services> serviceList = new ArrayList<>();
        carDTO.getServices().forEach(x -> serviceList.add(new Services(x.getDate(), x.getKilometers(), x.getDescriptions())));
        Car car = new Car(carDTO.getBrand(), carDTO.getModel(), carDTO.getManufacturingDate(), carDTO.getNumberOfKilometers(), carDTO.getDoors(), carDTO.getPrice(), carDTO.getCurrency(), serviceList, carDTO.getCountOfOwners());
        carRepository.saveNewCar(car);
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.getAllVehicles().stream().map(CarDTO::new).toList();
    }

    public List<CarDTO> getCarsByDate(Date initialDate, Date finalDate){
        return getAllCars().stream()
                .filter(x -> x.getManufacturingDate().after(initialDate))
                .filter(x -> x.getManufacturingDate().before(finalDate)).toList();
    }

    public List<CarDTO> getCarsByPrice(Double initialPrice, Double finalPrice){
        return getAllCars().stream().filter(x -> x.getPrice() >= initialPrice && x.getPrice() <= finalPrice).toList();
    }

    @Override
    public CarDTO getCarById(Integer id) {
        Car carById = carRepository.getCarById(id);
        if (carById==null){
            return null;
        }
        return new CarDTO(carById);
    }
}
