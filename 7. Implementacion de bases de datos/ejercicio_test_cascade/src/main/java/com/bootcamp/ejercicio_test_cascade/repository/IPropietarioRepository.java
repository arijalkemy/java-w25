package com.bootcamp.ejercicio_test_cascade.repository;

import com.bootcamp.ejercicio_test_cascade.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPropietarioRepository extends JpaRepository<Propietario, Integer> {
}
