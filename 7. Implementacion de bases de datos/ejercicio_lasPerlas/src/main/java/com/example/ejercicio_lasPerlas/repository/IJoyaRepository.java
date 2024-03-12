package com.example.ejercicio_lasPerlas.repository;

import com.example.ejercicio_lasPerlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {

}
