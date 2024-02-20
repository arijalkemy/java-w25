package com.example.deporte.repository;

import com.example.deporte.model.Deporte;
import lombok.Getter;

import java.util.ArrayList;

public class DeporteRepository {
    @Getter
    private static ArrayList<Deporte> deportes = new ArrayList<Deporte>();

    public static void addDeporte(Deporte deporte) {
        deportes.add(deporte);
    }

    public static String getDeporte(String nombre) {
        for (Deporte deporte : deportes) {
            if (deporte.getNombre().equals(nombre)) {
                return ((Integer) deporte.getNivel()).toString();
            }
        }
        return null;
    }
}
