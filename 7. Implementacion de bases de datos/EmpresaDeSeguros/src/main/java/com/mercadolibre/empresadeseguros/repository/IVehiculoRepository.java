package com.mercadolibre.empresadeseguros.repository;

import com.mercadolibre.empresadeseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> findAllVehicles();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioDeFabricacion")
    List<Vehiculo> findByAnioFabricacion();

    @Query("SELECT v FROM Vehiculo v WHERE v.cantidadDeRuedas > :cantRuedasQ AND v.anioDeFabricacion = YEAR (current date)")
    List<Vehiculo> findByWheelsQuantityAndCurrentYear(@Param("cantRuedasQ") Integer cantRuedas);

    @Query("SELECT DISTINCT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > :perdidaQ")
    List<Vehiculo> findByPerdidaEconomica(@Param("perdidaQ") Integer perdida);
    @Query("SELECT v,sum(s.perdidaEconomica) from Vehiculo v join v.siniestros s where s.perdidaEconomica > :perdida group by v")
    List<HashMap<Vehiculo,Integer>> findbyPerdidaEconomicaTotal(@Param("perdidaQ") Integer perdida);

}