package com.mercadolibre.hql_seguro_autos.repository;

import com.mercadolibre.hql_seguro_autos.entity.projections.PatenteMarca;
import com.mercadolibre.hql_seguro_autos.entity.projections.PatenteMarcaModelo;
import com.mercadolibre.hql_seguro_autos.entity.projections.PerdidasEconomicas;
import com.mercadolibre.hql_seguro_autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente AS patente, v.marca AS marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<PatenteMarca> findPatenteAndMarcaOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > :cantidadRuedas AND v.anioFabricacion = :anioFabricacion")
    List<String> findPatenteAndMarcaByCantidadRuedasGreaterThanAndAnioFabricacionEquals(int cantidadRuedas, int anioFabricacion);

    @Query("SELECT v.patente AS patente, v.marca AS marca, v.modelo AS modelo FROM Vehiculo v JOIN Siniestro s ON s.vehiculo.id = v.id WHERE s.perdidaEconomica > :perdidaEconomica")
    List<PatenteMarcaModelo> findMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan(Double perdidaEconomica);

    @Query("SELECT v.patente AS patente, v.marca AS marca, v.modelo AS modelo, SUM(s.perdidaEconomica) AS perdidaTotal FROM Vehiculo v " +
            "JOIN Siniestro s ON s.vehiculo.id = v.id " +
            "WHERE v.id IN (SELECT s2.vehiculo.id FROM Siniestro s2 WHERE s2.perdidaEconomica > 10000) " +
            "GROUP BY v.id")
    List<PerdidasEconomicas> findPerdidasSumMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan(Double perdidaEconomica);
}
