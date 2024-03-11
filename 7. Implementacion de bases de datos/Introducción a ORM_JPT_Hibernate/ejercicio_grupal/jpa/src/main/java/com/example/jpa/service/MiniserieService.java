package com.example.jpa.service;

import com.example.jpa.model.Miniserie;
import com.example.jpa.repository.MiniserieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniserieService {

    MiniserieRepository miniserieRepository;

    public MiniserieService(MiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }

    public Miniserie crearMiniSerie(
            Miniserie miniserie
    ) {
        miniserieRepository.save(miniserie);
        return miniserie;
    }

}
