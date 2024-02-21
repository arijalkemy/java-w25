package com.example.concesionario.services;

import com.example.concesionario.dto.AutomovilDto;
import com.example.concesionario.entities.Automovil;
import com.example.concesionario.repository.IConcesionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConcesionarioService implements IConcesionarioService{
    @Autowired
    private IConcesionarioRepository repository;


    @Override
    public AutomovilDto addAutomovil(Automovil automovil) {
        this.repository.addAutomovil(automovil);
        return new AutomovilDto(automovil.getId(),
                                automovil.getBrand(),
                                automovil.getManufacturingDate(),
                                automovil.getNumberOfKilometers(),
                                automovil.getDoors(),
                                automovil.getPrice(),
                                automovil.getCurrency(),
                                automovil.getCountOfOwners());
    }

    @Override
    public List<AutomovilDto> getAllAutomoviles() {
        return this.repository.getAll().stream().map(
                a -> new AutomovilDto(a.getId(),
                                      a.getBrand(),
                                      a.getManufacturingDate(),
                                      a.getNumberOfKilometers(),
                                      a.getDoors(),
                                      a.getPrice(),
                                      a.getCurrency(),
                                      a.getCountOfOwners())).toList();
    }

    @Override
    public List<AutomovilDto> getAllAutomovilesByDate(Date dateMin, Date dateMax) {
        return this.repository.getAll().stream().
                filter(a -> a.getManufacturingDate().compareTo(dateMin)>= 0 && a.getManufacturingDate().compareTo(dateMax) <= 0).
                map( a -> new AutomovilDto(a.getId(),
                        a.getBrand(),
                        a.getManufacturingDate(),
                        a.getNumberOfKilometers(),
                        a.getDoors(),
                        a.getPrice(),
                        a.getCurrency(),
                        a.getCountOfOwners())).toList();
    }

    @Override
    public List<AutomovilDto> getAllAutomovilesByPrice(double priceMin, double priceMax) {
        return this.repository.getAll().stream().
                filter(a -> a.getPrice() >= priceMin && a.getPrice() <= priceMax).
                map( a -> new AutomovilDto(a.getId(),
                        a.getBrand(),
                        a.getManufacturingDate(),
                        a.getNumberOfKilometers(),
                        a.getDoors(),
                        a.getPrice(),
                        a.getCurrency(),
                        a.getCountOfOwners())).toList();
    }

    @Override
    public AutomovilDto getAutomovil(int id) {
        Automovil automovil = this.repository.getById(id);

        return new AutomovilDto(automovil.getId(),
                                automovil.getBrand(),
                                automovil.getManufacturingDate(),
                                automovil.getNumberOfKilometers(),
                                automovil.getDoors(),
                                automovil.getPrice(),
                                automovil.getCurrency(),
                                automovil.getCountOfOwners());
    }
}
