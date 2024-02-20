package com.example.deporte.factory;

import com.example.deporte.model.Deporte;
import com.example.deporte.repository.DeporteRepository;

public class DeporteFactory {
    // Create deportes
    public static void createDeportes() {
        DeporteRepository.addDeporte(new Deporte("Futbol", 3));
        DeporteRepository.addDeporte(new Deporte("Basket", 5));
        DeporteRepository.addDeporte(new Deporte("Tenis", 4));
        DeporteRepository.addDeporte(new Deporte("Voley", 3));
        DeporteRepository.addDeporte(new Deporte("Handball", 3));
        DeporteRepository.addDeporte(new Deporte("Natacion", 2));
        DeporteRepository.addDeporte(new Deporte("Atletismo", 1));
    }
}
