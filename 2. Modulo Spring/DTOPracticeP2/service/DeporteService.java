package com.meli.firstcontroller.sportsDTOPractice.service;

import com.meli.firstcontroller.sportsDTOPractice.dto.request.CreatePersonDTO;
import com.meli.firstcontroller.sportsDTOPractice.dto.response.DeporteNivelDTO;
import com.meli.firstcontroller.sportsDTOPractice.dto.response.DeporteDTO;
import com.meli.firstcontroller.sportsDTOPractice.model.Deportista;
import com.meli.firstcontroller.sportsDTOPractice.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteService {

    public static List<Deporte> deportes;
    public DeporteService() {
        deportes = List.of(
                new Deporte("football", 1),
                new Deporte("running", 1),
                new Deporte("swimming", 1),
                new Deporte("cycling", 2),
                new Deporte("tennis", 2),
                new Deporte("basketball", 2),
                new Deporte("golf", 3),
                new Deporte("rock climbing", 3),
                new Deporte("surfing", 3)
        );
    }

    public List<DeporteDTO> getSports() {
        return deportes.stream().map(deporte -> new DeporteDTO(deporte.getName())).toList();
    }

    private Deporte getSport(String name) {
        return deportes.stream().filter(deporte -> deporte.getName().equals(name)).findAny().orElse(null);
    }

    public DeporteNivelDTO getSportByName(String name) {
        return deportes.stream()
                .filter(deporte -> deporte.getName().equals(name))
                .map(deporte -> new DeporteNivelDTO(
                        getLevel(deporte.getLevel())
                ))
                .findAny()
                .orElse(null);
    }

    public String getLevel(int level) {
        return switch (level) {
            case 1 -> "Easy";
            case 2 -> "Medium";
            case 3 -> "Hard";
            default -> throw new RuntimeException("Sport level is not valid");
        };
    }


}
