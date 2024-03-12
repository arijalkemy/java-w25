package com.implementacionbd.ejercicio.repository;

import com.implementacionbd.ejercicio.models.Vehiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    // 1.- Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente FROM Vehiculo AS v")
    List<String> findPatentes();

    // 2.- Listar la patente y la marca de todos los vehículos ordenados por año de
    // fabricación.
    @Query("SELECT v FROM Vehiculo AS v ORDER BY v.anyoFabricacion")
    List<Vehiculo> findByPatenteAndMarcaPorAnio();

    // 3.- Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND YEAR(v.anyoFabricacion) = YEAR(CURDATE())")
    List<String> findPatentesRuedasYAnio();

    // 4.- Listar la matrícula, marca y modelo de todos los vehículos que hayan
    // tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT v FROM Vehiculo v WHERE v.id IN (SELECT s.id FROM Siniestro AS s WHERE s.perdidaEconomica>= :perdida)")
    List<Vehiculo> findSiniestroMayorA(@Param("perdida") Integer perdida);
}
