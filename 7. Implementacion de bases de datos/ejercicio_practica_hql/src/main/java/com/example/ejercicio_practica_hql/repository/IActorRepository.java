package com.example.ejercicio_practica_hql.repository;

import com.example.ejercicio_practica_hql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {
    @Query("select a from Actor a")
    List<Actor> listActors();
}
