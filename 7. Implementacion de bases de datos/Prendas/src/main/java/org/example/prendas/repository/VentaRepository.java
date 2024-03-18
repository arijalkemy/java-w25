package org.example.prendas.repository;

import org.example.prendas.entity.Prenda;
import org.example.prendas.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface VentaRepository extends JpaRepository<Venta,Long> {
    List<Venta> findByDate(LocalDate date);
    Venta findByNumber(Long number);

    @Query("SELECT v.prendas FROM Venta v WHERE v.number = :number")
    Set<Prenda> getVentaPrendas(long number);
}
