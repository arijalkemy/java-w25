package com.example.ejercicio_seguros.repository;

import com.example.ejercicio_seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVehiculoRepositorio extends JpaRepository<Vehiculo, Long> {

    @Query("select v.patente from Vehiculo v")
    List<String> findPatentesOfVehiculos();

    @Query("select v.patente, v.marca from Vehiculo v order by v.anioFabricacion")
    List<Vehiculo> findPatenteAndMarcaOfVehiculosOrderByAnio();

    @Query("select v.patente from Vehiculo  v where v.cantidadRuedas > :ruedas and v.anioFabricacion = :anio")
    List<String> findPatenteOfVehiculosByRuedasAndAnio(@Param("ruedas") Integer ruedas, @Param("anio")Integer anio);

    @Query("select distinct v.patente, v.marca, v.modelo from Vehiculo v join Siniestro s on s.idVehiculoDenunciado = v where s.perdidaEconomica > :perdida")
    List<Vehiculo> findVehiculoSiniestroOfVehiculosByPerdida(@Param("perdida") double perdida);

}
