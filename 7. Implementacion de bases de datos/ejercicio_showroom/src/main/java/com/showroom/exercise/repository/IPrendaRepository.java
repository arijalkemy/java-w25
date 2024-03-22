package com.showroom.exercise.repository;

import com.showroom.exercise.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findAllByTalla(String talla);
    List<Prenda> findAllByNombreContainingIgnoreCase(String nombre);
}
