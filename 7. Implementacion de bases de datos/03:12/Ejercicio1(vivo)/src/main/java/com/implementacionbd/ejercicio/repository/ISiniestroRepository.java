package com.implementacionbd.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.implementacionbd.ejercicio.models.Siniestro;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

}