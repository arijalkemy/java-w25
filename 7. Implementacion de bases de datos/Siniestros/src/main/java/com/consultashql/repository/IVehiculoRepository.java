package com.consultashql.repository;

import com.consultashql.DTO.response.PatentesMarcaDTO;
import com.consultashql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    /*
    Listar la matrícula, marca y modelo de todos los
    vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    */
    @Query("select v.patente, v.marca, v.modelo from Vehiculo v " +
            "inner join v.siniestros s " +
            "where s.perdida_economica > :monto ")
    List<Vehiculo> findVehicleByLossGreaterThan(@Param("monto") Double monto);

    //Listar la patente y la marca de todos los vehículos
    // ordenados por año de fabricación.
    @Query("from Vehiculo v order by v.anio")
    List<Vehiculo> findVehiculosOrderedByAnio();

    //Listar la patente de todos los vehículos que tengan
    //más de cuatro ruedas y hayan sido fabricados en el corriente año
    @Query("from Vehiculo v where v.cantidad_ruedas > 4 and v.anio = 2024")
    List<Vehiculo> findVehiculoByAnioAndCantidadRuedas();
}
