package com.practicas.MiniSeries.service;

import com.practicas.MiniSeries.model.MiniSerie;
import com.practicas.MiniSeries.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MiniSerieService {
    IMiniserieRepository miniserieRepository;

    public MiniSerieService(IMiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }

    public MiniSerie getMiniserieByName(String name){
        return miniserieRepository.findFirstByName(name).get();
    }

    public MiniSerie addMiniSerie(MiniSerie miniSerie) {
        return miniserieRepository.save(miniSerie);
    }
}
