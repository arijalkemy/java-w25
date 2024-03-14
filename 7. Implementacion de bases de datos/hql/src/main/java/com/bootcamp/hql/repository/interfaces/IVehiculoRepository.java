package com.bootcamp.hql.repository.interfaces;

import com.bootcamp.hql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.time.Year;
import org.springframework.data.repository.query.Param;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    //Listar las patentes de todos los vehículos registrados
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findVehiculoByPatente();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v.patente,v.marca FROM Vehiculo v ORDER BY v.annoFabricacion")
    List<String[]> findVehiculosOrderByAnnoFabricacion();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    List<Vehiculo> findVehiculoByRuedasIsGreaterThanEqualAndAnnoFabricacion(Integer ruedas, Year anno);

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    //con pérdida mayor de 10000 pesos.
    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > :perdida_economica")
    List<Vehiculo> findVehiculoBySiniestroWithLossGreater(@Param("perdida_economica")Double perdidaEconomica);

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
    // con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query(
        "SELECT distinct v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.siniestros s " +
        "WHERE s.perdidaEconomica > :perdida_economica"
    )
    List<Object[]> findByPerdidaEconomicaGreaterThan(
        @Param("perdida_economica") Double perdidaEconomica
    );
    @Query(
            "SELECT sum(s.perdidaEconomica) FROM Vehiculo v JOIN v.siniestros s " +
                    "WHERE s.perdidaEconomica > :perdida_economica"
    )
    Double findByPerdidaEconomicaGreaterThanAndSumPerdidaEconomica(
            @Param("perdida_economica") Double perdidaEconomica
    );


}