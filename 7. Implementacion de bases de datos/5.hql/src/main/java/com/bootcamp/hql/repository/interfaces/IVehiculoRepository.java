package com.bootcamp.hql.repository.interfaces;

import com.bootcamp.hql.dto.MatriculaMarcaModeloDto;
import com.bootcamp.hql.dto.PatenteMarcaDto;
import com.bootcamp.hql.dto.PatentesDto;
import com.bootcamp.hql.model.Vehiculo;
import com.bootcamp.hql.model.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.time.Year;
import org.springframework.data.repository.query.Param;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("FROM Vehiculo v")
    List<Vehiculo> findVehiculos();

    @Query("FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> findVehiculosOrderByAnioFabricacion();

    @Query("FROM Vehiculo v WHERE v.ruedas > :ruedas AND v.anioFabricacion = :anio")
    List<Vehiculo> findVehiculosByRuedasGreaterThanAndAnioFabricacion(
        @Param("ruedas") Integer ruedas,
        @Param("anio") Year anio
    );

    @Query("FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > :perdida_economica")
    List<Vehiculo> findVehiculoBySiniestroWithLossGreater(@Param("perdida_economica")Double perdidaEconomica);

    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) " +
            "FROM Vehiculo v JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > :perdida_economica " +
            "GROUP BY v.patente, v.marca, v.modelo")
    List<Object[]> findVehiculoWithLossGreater(@Param("perdida_economica")Double perdidaEconomica);
}