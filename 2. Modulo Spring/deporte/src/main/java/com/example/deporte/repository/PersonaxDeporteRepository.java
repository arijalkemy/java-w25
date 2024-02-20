package com.example.deporte.repository;

import com.example.deporte.model.PersonaxDeporte;
import lombok.Getter;

import java.util.ArrayList;

public class PersonaxDeporteRepository {
    @Getter
    private static ArrayList<PersonaxDeporte> personaxDeportes = new ArrayList<>();

    public static void addPersonaxDeporte(PersonaxDeporte personaxDeporte) {
        personaxDeportes.add(personaxDeporte);
    }

    public static PersonaxDeporte getPersonaxDeporte(String nombre) {
        for (PersonaxDeporte personaxDeporte : personaxDeportes) {
            if (personaxDeporte.getPersona().getNombre().equals(nombre)) {
                return personaxDeporte;
            }
        }
        return null;
    }
}
