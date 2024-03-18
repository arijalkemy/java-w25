package org.example.prendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.prendas.entity.Prenda;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda,Long> {

    List<Prenda> findByTalle(String talle);
    List<Prenda> findByNombreContainingIgnoreCase(String nombre);
    Prenda findByCodigo(Long codigo);

}
