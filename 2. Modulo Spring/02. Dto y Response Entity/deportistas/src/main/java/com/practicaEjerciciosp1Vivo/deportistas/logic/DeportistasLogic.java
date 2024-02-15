package com.practicaEjerciciosp1Vivo.deportistas.logic;

import com.practicaEjerciciosp1Vivo.deportistas.dto.DeportistasDTO;
import com.practicaEjerciciosp1Vivo.deportistas.model.Deporte;
import com.practicaEjerciciosp1Vivo.deportistas.model.Persona;
import com.practicaEjerciciosp1Vivo.deportistas.repositories.DeporteRepository;
import com.practicaEjerciciosp1Vivo.deportistas.repositories.PersonaRepository;
import com.practicaEjerciciosp1Vivo.deportistas.repositories.RelacionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeportistasLogic {
    private DeporteRepository deporteRepository;
    private PersonaRepository personaRepository;
    private RelacionRepository relacionRepository;

    public DeportistasLogic() {
        this.deporteRepository = new DeporteRepository();
        this.personaRepository = new PersonaRepository();
        this.relacionRepository = new RelacionRepository(personaRepository.getPersonas(), deporteRepository.getDeportes());
    }

    public List<Deporte> getAllSports(){
        return deporteRepository.getDeportes();
    }

    public Deporte searchSport(String name){
        return deporteRepository.getDeportes().stream().filter(dep -> dep.getNombre().equals(name)).findFirst().orElse(null);
    }

    public List<DeportistasDTO> getPersonsSport() {
        List<DeportistasDTO> personasDTO = new ArrayList<>();
        Map<Persona, Deporte> personSports = this.relacionRepository.getPersonSport();

        for (Map.Entry<Persona, Deporte> entry : personSports.entrySet()) {
            Persona persona = entry.getKey();
            Deporte deporte = entry.getValue();

            DeportistasDTO deportistasDTO = new DeportistasDTO();
            deportistasDTO.setNombre(persona.getNombre());
            deportistasDTO.setApellido(persona.getApellido());
            deportistasDTO.setDeporte(deporte.getNombre());

            personasDTO.add(deportistasDTO);
        }

        return personasDTO;
    }
}
