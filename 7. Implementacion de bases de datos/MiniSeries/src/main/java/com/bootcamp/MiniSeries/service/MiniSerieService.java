package com.bootcamp.MiniSeries.service;

import com.bootcamp.MiniSeries.repository.IMiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
}
