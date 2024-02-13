package org.example.concesionariaautos.services;

import org.example.concesionariaautos.dtos.AutomovilDto;
import org.example.concesionariaautos.dtos.AutomovilNoServicesDto;
import org.example.concesionariaautos.models.Automovil;
import org.example.concesionariaautos.repositories.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovilServiceImp implements AutomovilService {

    public final AutomovilRepository automovilRepository;

    public AutomovilServiceImp(AutomovilRepository automovilRepository) {
        this.automovilRepository = automovilRepository;
    }

    @Override
    public List<AutomovilNoServicesDto> getAll() {
        return automovilRepository.getAll().stream().map(AutomovilNoServicesDto::new).toList();
    }

    @Override
    public AutomovilDto getById(String id) {
        return new AutomovilDto(automovilRepository.getById(id));
    }

    @Override
    public List<AutomovilNoServicesDto> getByDate(String since, String to) {
        return automovilRepository.getByDate(since, to).stream().map(AutomovilNoServicesDto::new).toList();
    }

    @Override
    public List<AutomovilNoServicesDto> getByPrice(String since, String to) {
        return automovilRepository.getByPrice(since, to).stream().map(AutomovilNoServicesDto::new).toList();
    }

    @Override
    public void addAutomovil(AutomovilDto automovil) {
        automovilRepository.addAutomovil(new Automovil(automovil));
    }
}
