package org.example.concesionariaautos.services;

import org.example.concesionariaautos.dtos.AutomovilDto;
import org.example.concesionariaautos.dtos.AutomovilNoServicesDto;

import java.util.List;

public interface AutomovilService {
    public List<AutomovilNoServicesDto> getAll();

    public AutomovilDto getById(String id);

    public List<AutomovilNoServicesDto> getByDate(String since, String to);

    public List<AutomovilNoServicesDto> getByPrice(String since, String to);

    public void addAutomovil(AutomovilDto automovil);


}
