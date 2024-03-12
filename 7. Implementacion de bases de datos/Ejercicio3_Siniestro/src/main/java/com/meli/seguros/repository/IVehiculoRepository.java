package com.meli.seguros.repository;

import com.meli.seguros.dto.VehiculoSiniestroDTO;
import com.meli.seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPantentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Object[]> findAllPantenteYMarcaOrderAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = :anio")
    List<String> findPatenteByCantidadRuedasYAnioFabricacion(@Param("anio") Integer anio);

    @Query("SELECT VehiculoSiniestroDTO(v, SUM(s.perdidaEconomica)) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v")
    List<VehiculoSiniestroDTO> findAllVehiculosSiniestrosWithPerdidaMayorDeDiezMilPesos();
}
