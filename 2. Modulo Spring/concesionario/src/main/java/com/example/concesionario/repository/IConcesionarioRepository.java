package com.example.concesionario.repository;

import com.example.concesionario.entities.Automovil;

import java.util.Date;
import java.util.List;

public interface IConcesionarioRepository {
    Automovil addAutomovil(Automovil automovil);

    List<Automovil> getAll();

    List<Automovil> getAllByManufacturingDate(Date minDate, Date maxxDate);

    List<Automovil> getAllByPrices(double minPrice, double maxPrice);

    Automovil getById(int id);


}
