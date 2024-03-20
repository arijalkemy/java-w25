package org.example.seguros.repository;

import org.example.seguros.entity.Siniestro;
import org.example.seguros.repository.proyection.PatenteMarcaModelo;
import org.example.seguros.repository.proyection.PatenteMarcaModeloTotalPerdida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

    @Query("select s.vehiculo.patente as patente,s.vehiculo.marca as marca,s.vehiculo.modelo as modelo from Siniestro s where s.perdidaEconomica > 10000")
    List <PatenteMarcaModelo> findPatenteMarcaModeloByPerdidaEconomicaMayorADiezMil();

    @Query("select s.vehiculo.patente as patente,s.vehiculo.marca as marca,s.vehiculo.modelo as modelo,sum(s.perdidaEconomica) as totalPerdida from Siniestro s group by s.vehiculo having sum(s.perdidaEconomica) > 10000")
    List <PatenteMarcaModeloTotalPerdida> findPatenteMarcaModeloByPerdidaEconomicaMayorADiezMilGroupByVehiculo();

}
