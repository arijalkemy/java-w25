package com.example.concesionario.repository;

import com.example.concesionario.entities.Automovil;
import com.example.concesionario.entities.Service;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ConcesionarioRepository implements IConcesionarioRepository {
    private static List<Automovil> automoviles = new ArrayList<>(Arrays.asList(
            new Automovil(1, "Toyota", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(), 50000, 4, 25000.0, "USD", Arrays.asList(new Service(new Date(2024, 1, 5), 400, "Test")), 2),
            new Automovil(2, "Subaru", new GregorianCalendar(2022, Calendar.FEBRUARY, 3).getTime(), 150000, 4, 15000.0, "USD", Arrays.asList(new Service(new Date(2023, 1, 5), 400, "Test")), 1)
    ));


    @Override
    public Automovil addAutomovil(Automovil automovil) {
        automoviles.add(automovil);
        return automovil;
    }

    @Override
    public List<Automovil> getAll() {
        return automoviles;
    }

    @Override
    public List<Automovil> getAllByManufacturingDate(Date minDate, Date maxxDate) {
        return automoviles.stream().filter(a -> a.getManufacturingDate().compareTo(minDate) >= 0 && a.getManufacturingDate().compareTo(maxxDate) <= 0).toList();
    }

    @Override
    public List<Automovil> getAllByPrices(double minPrice, double maxPrice) {
        return automoviles.stream().filter(a -> a.getPrice() >= minPrice && a.getPrice() <= maxPrice).toList();
    }

    @Override
    public Automovil getById(int id)  {
        try{
            return automoviles.stream().filter(a -> a.getId() == id).findFirst().get();
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
