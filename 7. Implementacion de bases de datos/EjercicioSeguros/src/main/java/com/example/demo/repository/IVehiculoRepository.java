package com.example.demo.repository;

import com.example.demo.dto.PatenteYMarcaDto;
import com.example.demo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findPatentes();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioDeFabricacion")
    List<Vehiculo> findByPatenteAndMarcaPorAnio();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadDeRuedas > 4 AND v.anioDeFabricacion = YEAR(CURDATE())")
    List<String> findPatentesRuedasYAnio();

    @Query("SELECT v FROM Vehiculo v WHERE v.id IN (SELECT s.idSiniestro FROM Siniestro s WHERE s.perdidaEconomica>= :perdida)")
    List<Vehiculo> findSiniestroMayorA(@Param("perdida") Integer perdida);

    @Query("SELECT SUM(s.perdidaEconomica) FROM Siniestro s WHERE s.perdidaEconomica>= :perdida")
    String findSumaSiniestroMayorA(@Param("perdida") Integer perdida);
}
