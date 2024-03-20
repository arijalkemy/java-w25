package com.bootcamp.ejercicio_showroom.repository;

import com.bootcamp.ejercicio_showroom.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Venta, Long> {

    List<Venta> getVentaByFecha(LocalDate date);
    Optional<Venta> findByNumero(Long id);
}
