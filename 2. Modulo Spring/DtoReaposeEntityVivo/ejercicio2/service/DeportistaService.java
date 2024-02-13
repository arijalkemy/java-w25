package com.meli.firstcontroller.sportsDTOPractice.service;


import com.meli.firstcontroller.sportsDTOPractice.dto.response.DeportistaDTO;
import com.meli.firstcontroller.sportsDTOPractice.model.Deportista;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeportistaService {

    public static List<Deportista> deportistas;

    public DeportistaService(List<Deportista> deportistas) {
        DeportistaService.deportistas = List.of(
                new Deportista("Pepe", "Perez", LocalDate.of(1998, 6, 7), DeporteService.deportes.get(1))
        );
    }

    public List<DeportistaDTO> getPersonsWSport() {
        return deportistas.stream()
                .filter(deportista -> deportista.getDeporte() != null)
                .map(deportista -> new DeportistaDTO(deportista.getName(), deportista.getLastName(), deportista.getDeporte().getName()))
                .toList();
    }

}
