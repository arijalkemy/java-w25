package com.implementacionbasedatos.ejercicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.implementacionbasedatos.ejercicio1.model.Jewerly;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly, Long> {
}
