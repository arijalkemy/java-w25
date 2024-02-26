package org.example.starwars.service;

import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.repository.IRepo;
import org.example.starwars.repository.RepoPersonajeImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Servicio {
    private RepoPersonajeImpl repo;

    public Servicio(RepoPersonajeImpl repo) {
        this.repo = repo;

    }

    public ResponseEntity<List<PersonajeDTO>> responder(String preg) {
        repo.cargar();
        return new ResponseEntity<>(this.repo.findAll().stream().filter(y -> {
            String[] w = y.getName().split(" ");
            if (Arrays.stream(w).anyMatch(q -> q.equals(preg))) {
                return true;
            }
            return false;
        }).map(x -> new PersonajeDTO(
                x.getName(), x.getHeight(), x.getMass(), x.getGender(), x.getHomeworld(), x.getSpecies()
        )).toList()
                , HttpStatus.OK);
    }
}
