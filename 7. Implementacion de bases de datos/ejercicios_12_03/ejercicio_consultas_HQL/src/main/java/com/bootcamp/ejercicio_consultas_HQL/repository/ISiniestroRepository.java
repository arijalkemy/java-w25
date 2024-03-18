package com.bootcamp.ejercicio_consultas_HQL.repository;

import com.bootcamp.ejercicio_consultas_HQL.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
