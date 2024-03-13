package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.dto.PlatesAndBrandsDTO;
import com.example.ejemplo_jpa.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT patente FROM Vehiculo")
    List<String> listAllVehiclePlates();
    @Query("SELECT new com.example.ejemplo_jpa.dto.PlatesAndBrandsDTO(patente, marca) FROM Vehiculo ORDER BY anioDeFabricacion")
    List<PlatesAndBrandsDTO> listAllVehiclePlatesAndBrands();

    @Query("SELECT patente FROM Vehiculo WHERE cantidadDeRuedas > 4 AND anioDeFabricacion = :anio")
    List<String> listAllVehiclePlatesByWheelsAndCurrentYear(@Param("anio") Integer anioActual);
}
