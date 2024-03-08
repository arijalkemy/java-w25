package com.miniseries.main.service;

import org.springframework.stereotype.Service;

import com.miniseries.main.repository.IMiniSerieRepository;

@Service
public class MiniSerieService {
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
}
