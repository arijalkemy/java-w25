package org.example.concesionariaautos.repositories;

import org.example.concesionariaautos.dtos.AutomovilDto;
import org.example.concesionariaautos.dtos.AutomovilNoServicesDto;
import org.example.concesionariaautos.models.Automovil;

import java.util.List;

public interface AutomovilRepository {

    public List<Automovil> getAll();

    public Automovil getById(String id);

    public List<Automovil> getByDate(String since, String to);

    public List<Automovil> getByPrice(String since, String to);

    public void addAutomovil(Automovil automovil);



}
