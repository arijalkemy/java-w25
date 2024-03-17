package com.meli.showroom.repository;

import com.meli.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda,Long> {

    List<Prenda> findAllByTalla(String talla);
    List<Prenda> findAllByNombreContains(String palabra);
}
