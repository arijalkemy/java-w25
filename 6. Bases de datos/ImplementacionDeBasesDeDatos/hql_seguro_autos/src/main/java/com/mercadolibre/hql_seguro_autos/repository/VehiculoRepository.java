package com.mercadolibre.hql_seguro_autos.repository;

import com.mercadolibre.hql_seguro_autos.dto.response.PatenteMarcaDto;
import com.mercadolibre.hql_seguro_autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> findPatenteAndMarcaOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > :cantidadRuedas AND v.anioFabricacion = :anioFabricacion")
    List<String> findPatenteAndMarcaByCantidadRuedasGreaterThanAndAnioFabricacionEquals(int cantidadRuedas, int anioFabricacion);
}
