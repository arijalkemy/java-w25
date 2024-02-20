package com.example.calculadoraCalorias.service;

import com.example.calculadoraCalorias.dto.PlatoDTO;
import com.example.calculadoraCalorias.repository.PlatoRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatosImpl implements Platos{

    private final PlatoRepositoryImpl platoRepositoryImpl;

    public PlatosImpl(PlatoRepositoryImpl platoRepositoryImpl) {
        this.platoRepositoryImpl = platoRepositoryImpl;
    }

    @Override
    public List<PlatoDTO> mostrasIngredientesPlato(String nombrePlato, int pesoEnGramo) {
        return null;
    }
}
