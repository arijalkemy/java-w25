package com.implementacionbd.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.implementacionbd.ejercicio.model.Prenda;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
    @Query("SELECT p FROM Prenda AS p WHERE p.talle LIKE CONCAT('%', :size, '%')")
    List<Prenda> findPrendaBySize(@Param("size") String size);

    @Query("SELECT p FROM Prenda AS p WHERE p.tipo LIKE CONCAT('%', :tipo, '%')")
    List<Prenda> findPrendaTipo(@Param("tipo") String tipo);
}
