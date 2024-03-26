package com.example.SegurosDeAutos.repository;

import com.example.SegurosDeAutos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Listar las patentes de todos los vehículos registrados.
    @Query("select v.patente from Vehiculo v")
    List<String> findAllPatentes();
    List<String> findPatenteBy();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("select v.patente, v.marca from Vehiculo v order by v.anioFabricacion")
    List<Object[]> findPatenteAndMarcaOrderedByAnioFabricacion();
    List<Object[]> findPatenteAndMarcaByOrderByAnioFabricacionAsc();

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("select v.patente from Vehiculo v where v.cantRuedas > 4 and v.anioFabricacion = :anoActual")
    List<String> findPatenteByCantRuedasAndAnioFabricacion(@Param("anoActual") Integer anoActual);
    @Query("select v.patente from Vehiculo v where v.cantRuedas > 4 and v.anioFabricacion = YEAR(CURRENT_DATE)")
    List<String> findPatentesByCantRuedasAndCurrentYear();
    List<String> findPatenteByCantRuedasGreaterThanAndAnioFabricacion(int cantRuedas, int anioFabricacion);

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v INNER JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Object[]> findMatriculaMarcaModeloByPerdidaMayor10000();
    List<Object[]> findPatenteAndMarcaAndModeloBySiniestrosPerdidaEconomicaGreaterThan(double perdidaEconomica);

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) FROM Vehiculo v INNER JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v.patente, v.marca, v.modelo")
    List<Object[]> findMatriculaMarcaModeloAndTotalPerdidaByPerdidaMayor10000();
    List<Object[]> findPatenteAndMarcaAndModeloAndSumPerdidaEconomicaBySiniestrosPerdidaEconomicaGreaterThanGroupByPatente(double perdidaEconomica);

}
