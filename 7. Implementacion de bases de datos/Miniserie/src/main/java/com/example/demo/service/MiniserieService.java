package com.example.demo.service;

import com.example.demo.controller.MiniserieDTO;
import com.example.demo.model.Miniserie;
import com.example.demo.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniserieService {

    IMiniserieRepository miniserieRepository;

    MiniserieService( IMiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }

    public String agregarMiniserie(MiniserieDTO miniserieDTO) {
        Miniserie miniserie = new Miniserie(
                miniserieDTO.id(),
                miniserieDTO.name(),
                miniserieDTO.rating(),
                miniserieDTO.amountOfAwards()
        );
        miniserieRepository.save(miniserie);
        return "allOk";
    }


}
