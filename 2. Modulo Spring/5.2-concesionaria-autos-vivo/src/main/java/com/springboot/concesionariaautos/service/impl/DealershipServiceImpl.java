package com.springboot.concesionariaautos.service.impl;

import com.springboot.concesionariaautos.dto.CarDTO;
import com.springboot.concesionariaautos.dto.CarServiceDTO;
import com.springboot.concesionariaautos.entity.Car;
import com.springboot.concesionariaautos.entity.CarService;
import com.springboot.concesionariaautos.repository.IDealershipRepository;
import com.springboot.concesionariaautos.repository.impl.DealershipRepositoryImpl;
import com.springboot.concesionariaautos.service.IDealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DealershipServiceImpl implements IDealershipService {
    private final IDealershipRepository dealershipRepository;

    @Autowired
    public DealershipServiceImpl(DealershipRepositoryImpl dealershipRepositoryImpl) {
        this.dealershipRepository = dealershipRepositoryImpl;
    }

    @Override
    public void createCar(CarDTO carDTO) {
        Car car = new Car(
                carDTO.getId(), carDTO.getBrand(), carDTO.getModel(), carDTO.getManufacturingDate(), carDTO.getNumberOfKilometers(),
                carDTO.getDoors(), carDTO.getPrice(), carDTO.getCurrency(), carDTO.getServices().stream()
                .map(carService -> new CarService(carService.getDate(), carService.getKilometers(), carService.getDescription())).toList(), carDTO.getCountOfOwners()
        );
        dealershipRepository.createCar(car);
    }

    @Override
    public List<CarDTO> getCars() {
        return dealershipRepository.getCars().stream()
                .map(car -> new CarDTO(
                        car.getId(), car.getBrand(), car.getModel(), car.getManufacturingDate(), car.getNumberOfKilometers(),
                        car.getDoors(), car.getPrice(), car.getCurrency(), car.getServices() != null ?
                        car.getServices().stream()
                        .map(carService -> new CarServiceDTO(carService.getDate(), carService.getKilometers(), carService.getDescription())).toList() : null,
                        car.getCountOfOwners()
                )).toList();
    }

    @Override
    public List<CarDTO> getCarsByDates(String dateSince, String dateTo) {
        return getCars().stream()
                .filter(carDTO -> LocalDate.parse(carDTO.getManufacturingDate()).isAfter(LocalDate.parse(dateSince)) &&
                        LocalDate.parse(carDTO.getManufacturingDate()).isBefore(LocalDate.parse(dateTo))).toList();
    }

    @Override
    public List<CarDTO> getCarsByPrices(String priceSince, String priceTo) {
        return getCars().stream()
                .filter(carDTO -> Double.parseDouble(carDTO.getPrice()) >= Double.parseDouble(priceSince) &&
                        Double.parseDouble(carDTO.getPrice()) <= Double.parseDouble(priceTo))
                .toList();
    }

    @Override
    public Optional<CarDTO> getCarById(Long id) {
        return getCars().stream().filter(carDTO -> carDTO.getId().equals(id)).findFirst();
    }
}
