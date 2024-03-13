package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
}
