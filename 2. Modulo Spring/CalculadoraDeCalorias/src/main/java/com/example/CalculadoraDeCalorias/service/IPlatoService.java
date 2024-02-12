package com.example.CalculadoraDeCalorias.service;

import com.example.CalculadoraDeCalorias.dto.response.CalculadoraDTO;

public interface IPlatoService {
    CalculadoraDTO calcular(String plato, int peso);
}
