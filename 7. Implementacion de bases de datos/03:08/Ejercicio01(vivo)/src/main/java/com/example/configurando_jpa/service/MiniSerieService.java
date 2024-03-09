package com.example.configurando_jpa.service;

import org.springframework.stereotype.Service;

import com.example.configurando_jpa.repository.IMiniSerieRepository;

@Service
public class MiniSerieService {
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
}
