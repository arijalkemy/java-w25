package com.bootcamp.ejercicio_test_cascade.repository;

import com.bootcamp.ejercicio_test_cascade.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {
}
