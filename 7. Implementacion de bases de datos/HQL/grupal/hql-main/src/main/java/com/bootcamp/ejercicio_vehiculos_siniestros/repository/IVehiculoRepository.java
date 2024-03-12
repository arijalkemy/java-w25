package com.bootcamp.ejercicio_vehiculos_siniestros.repository;

import com.bootcamp.ejercicio_vehiculos_siniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("select v from Vehiculo v where v.anioFabricacion = :year and v.cantidadDeRuedas > 4")
    List<Vehiculo> getVehiculoByNumberOfWheelsAndYear(@Param("year") Integer year);

    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> getVehiculoDataByEconomicLossGreaterThan10000();



}
