package com.bootcamp.hql.repository.interfaces;

import com.bootcamp.hql.model.projection.*;
import com.bootcamp.hql.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends CrudRepository<Vehiculo,Long> {
    //Listar las patentes de todos los vehículos registrados
    @Query("SELECT v.id AS id, v.patente AS patente FROM Vehiculo v")
    List<SelectPatente> findVehiculoByPatente();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query(
        "SELECT v.id AS id, v.patente AS patente, v.marca AS marca, v.annoFabricacion AS annoFabricacion " +
        "FROM Vehiculo v " +
        "ORDER BY v.annoFabricacion")
    List<SelectPatenteAndMarca> findVehiculosOrderByAnnoFabricacion();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @Query(
        "SELECT v.id AS id, v.patente AS patente, v.ruedas AS ruedas, v.annoFabricacion AS annoFabricacion " +
        "FROM Vehiculo v " +
        "WHERE v.ruedas > :ruedas AND v.annoFabricacion = :anno")
    List<SelectPatenteByRuedasAndAnnoFabricacion> findVehiculosByRuedasGreaterThanAndAnnoFabricacion(
        @Param("ruedas") Integer ruedas,
        @Param("anno") Integer anno
    );

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    //con pérdida mayor de 10000 pesos.
    @Query(
        "SELECT DISTINCT v.id AS id, v.patente AS patente, v.marca AS marca, v.modelo AS modelo " +
        "FROM Vehiculo v JOIN v.siniestros s " +
        "WHERE s.perdidaEconomica > :perdida_economica")
    List<SelectByPerdidaEconomica> findVehiculoJoinSiniestroByPerdidaEconomicaGreaterThan(
        @Param("perdida_economica") Double perdidaEconomica
    );

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    // con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query(
        "SELECT SUM(s.perdidaEconomica) " +
        "FROM Vehiculo v JOIN v.siniestros s " +
        "WHERE s.perdidaEconomica > :perdida_economica"
    )
    Double findPerdidaTotalByPerdidaEconomicaGreaterThan(
        @Param("perdida_economica") Double perdidaEconomica
    );
}