package com.springlh.ejercicios0802.repository;

import com.springlh.ejercicios0802.model.Deporte;
import com.springlh.ejercicios0802.model.Persona;
import com.springlh.ejercicios0802.model.Sintoma;
import com.springlh.ejercicios0802.model.SintomaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class SintomaRepository {
    List<Sintoma> sintomas = Arrays.asList(
            new Sintoma(1, "Fiebre", "Alto"),
            new Sintoma(2, "Cansancio", "Medio"),
            new Sintoma(3, "Tos seca", "Medio"),
            new Sintoma(4, "Dolor de garganta", "Bajo"),
            new Sintoma(5, "Pérdida del sentido del gusto", "Alto"),
            new Sintoma(6, "Pérdida del sentido del olfato", "Alto"),
            new Sintoma(7, "Dificultad para respirar", "Alto")
    );

    public List<SintomaDTO> getSintomas() {
        List<SintomaDTO> sintomaDTOS = new ArrayList<>();
        for (Sintoma s : sintomas) {

            SintomaDTO sDTO = new SintomaDTO(s.getNombre(), s.getNivelDeGravedad());
            sintomaDTOS.add(sDTO);
        }
        return sintomaDTOS;
    }

    public Optional<SintomaDTO> getSintomaByName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return Optional.empty();
        }

        for (Sintoma s : sintomas) {
            if (s.getNombre().equalsIgnoreCase(name.trim())) {
                SintomaDTO sDTO = new SintomaDTO(s.getNombre(), s.getNivelDeGravedad());
                return Optional.of(sDTO);
            }
        }
        return Optional.empty();
    }
}
