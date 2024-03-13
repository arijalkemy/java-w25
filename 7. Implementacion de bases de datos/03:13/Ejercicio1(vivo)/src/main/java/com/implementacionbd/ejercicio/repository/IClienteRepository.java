package com.implementacionbd.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implementacionbd.ejercicio.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
