package com.showroom.exercise.repository;

import com.showroom.exercise.model.Prenda;
import com.showroom.exercise.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
    @Query("select v.prendas from ventas v where v.numero=:numVenta")
    Set<Prenda> findPrendasFromVentaId(@Param("numVenta") Long numero);
}
