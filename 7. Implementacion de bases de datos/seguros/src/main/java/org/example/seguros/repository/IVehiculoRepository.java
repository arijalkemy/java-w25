package org.example.seguros.repository;

import org.example.seguros.entity.Vehiculo;
import org.example.seguros.repository.proyection.PatenteMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select v.patente from Vehiculo v")
    List<String> findAllPatentes();

    @Query("select v.patente,v.marca from Vehiculo v order by v.anioFabricacion")
    List<PatenteMarca> findAllPatentesAdMarcaOrderByAnioFabricacion();

    @Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 and v.anioFabricacion = YEAR(CURRENT_DATE)")
    List<String> findPatentesVehiculosMasCuatroRuedasByAnioActual();


}


