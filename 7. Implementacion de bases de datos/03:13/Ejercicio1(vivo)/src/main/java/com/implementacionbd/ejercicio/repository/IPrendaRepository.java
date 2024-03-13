package com.implementacionbd.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implementacionbd.ejercicio.model.Prenda;

public interface IPrendaRepository extends JpaRepository<Prenda, Long> {

}
