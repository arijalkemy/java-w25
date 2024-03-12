package com.example.ejercicio_practica_hql.controller;

import com.example.ejercicio_practica_hql.dto.response.ActorDTO;
import com.example.ejercicio_practica_hql.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {
    IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors/favMovies")
    ResponseEntity<List<ActorDTO>> listActorsWithFavMovies(){
        return ResponseEntity.ok()
                .body(actorService.listActorsWithFavMovies());
    }
}
