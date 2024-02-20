package com.example.deporte.factory;

import com.example.deporte.model.Deporte;
import com.example.deporte.model.Persona;
import com.example.deporte.model.PersonaxDeporte;
import com.example.deporte.repository.DeporteRepository;
import com.example.deporte.repository.PersonaRepository;
import com.example.deporte.repository.PersonaxDeporteRepository;

import java.util.ArrayList;

public class DeportistaFactory {
    public static void createDeportistas() {
        ArrayList<Deporte> deportes = DeporteRepository.getDeportes();
        ArrayList<Persona> personas = PersonaRepository.getPersonas();
        PersonaxDeporteRepository.addPersonaxDeporte(new PersonaxDeporte(personas.get(0), deportes.get(0)));
        PersonaxDeporteRepository.addPersonaxDeporte(new PersonaxDeporte(personas.get(1), deportes.get(1)));
        PersonaxDeporteRepository.addPersonaxDeporte(new PersonaxDeporte(personas.get(2), deportes.get(2)));
        PersonaxDeporteRepository.addPersonaxDeporte(new PersonaxDeporte(personas.get(3), deportes.get(3)));
    }
}
