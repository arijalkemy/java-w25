package com.bootcamp.ejercicio_test_cascade.repository;

import com.bootcamp.ejercicio_test_cascade.model.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVacunaRepository extends JpaRepository<Vacuna, Integer> {
}
