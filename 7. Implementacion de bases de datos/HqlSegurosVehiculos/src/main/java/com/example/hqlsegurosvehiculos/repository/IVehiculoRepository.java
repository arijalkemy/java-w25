package com.example.hqlsegurosvehiculos.repository;

import com.example.hqlsegurosvehiculos.entity.PatenteAndYear;
import com.example.hqlsegurosvehiculos.entity.Siniestro;
import com.example.hqlsegurosvehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();
    @Query("SELECT s FROM Siniestro s")
    List<Siniestro> findAllSiniestros();
    @Query("SELECT v.patente, v.marca, v.yaerFabricacion FROM Vehiculo v ORDER BY v.yaerFabricacion DESC")
    List<Object[]> findAllByOrderByYearFabricacionAsc();

    @Query("SELECT v.patente, v.marca, v.yaerFabricacion FROM Vehiculo v WHERE v.cantRuedas > 4" +
            " AND v.yaerFabricacion = 2024")
    List<Object[]> findAllByCantRuedasGreaterThan4();
}
