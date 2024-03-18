package com.bootcamp.ejercicio_consultas_HQL.repository;

import com.bootcamp.ejercicio_consultas_HQL.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findAllByOrderByAnyoFabricacion();
    List<Vehiculo> findAllByAnyoFabricacion(int anyoFabricacion);

    @Query("select v " +
            "from Vehiculo v join v.siniestros s " +
            "where s.id is not null and s.perdidaEconomica > 10000")
    List<Vehiculo> findAllBySiniestrosAndPerdidaDiezMil();
    @Query("select SUM(s.perdidaEconomica) " +
            "from Vehiculo v join v.siniestros s " +
            "where s.id is not null and s.perdidaEconomica > 10000 and v.id = :vehiculoId")
    Double sumPerdidaEconomicaByVehiculoId(@Param("vehiculoId") Long vehiculoId);
}
