package com.implementacionbd.ejercicio.repository;


import com.implementacionbd.ejercicio.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
// 1-Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> findAllVehicles();

    // 2-Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    /*
    ESTA MAL :(
    @Query("SELECT v.patente, v.marca FROM Vehiculo AS v ORDER BY v.anyoFabricacion")
    List<Vehiculo> findVehiclesOrderByYear();
    */


    //3-Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("select v from Vehiculo v where v.anyoFabricacion =: currentYear")
    List<Vehiculo> findVehiculosByAnyoFabricacion(@Param("name")LocalDate currentYear);

    //4-Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("select v")

}

/**
 De las clases mencionadas, se sabe que un vehículo puede denunciar múltiples siniestros y
 un siniestro pertenece a un solo vehículo.


 Se debe:

 Crear la aplicación utilizando la separación de capas adecuada.
 Crear los endpoints necesarios para crear y consultar los vehículos y siniestros denunciados.
 Utilizando consultas HQL, se pide:
 1-Listar las patentes de todos los vehículos registrados.
 2-Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
 3-Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
 4-Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
 5-Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
 6-Almacenar el resultado de la consulta en una lista de listas de dos elementos; el primero será un Vehículo y el segundo un Integer. Habrá que crear la clase VehiculoSiniestro con su correspondiente constructor.
 */
