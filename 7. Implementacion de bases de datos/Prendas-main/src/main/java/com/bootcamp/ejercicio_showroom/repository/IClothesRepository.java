package com.bootcamp.ejercicio_showroom.repository;

import com.bootcamp.ejercicio_showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IClothesRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findAll();

    Optional<Prenda> findByCodigo(Long id);

    List<Prenda> findPrendasByTalle(String talle);

    List<Prenda> findPrendasByNombreContainsIgnoreCase(String word);

}
