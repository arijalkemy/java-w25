package com.example.vehiculossiniestros.repository;

import com.example.vehiculossiniestros.dto.PatenteMarcaDto;
import com.example.vehiculossiniestros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
  @Query("select v.patente from Vehiculo v")
  List<String> getAllPatentes();

  @Query("select v.patente, v.marca from Vehiculo v order by  v.fecha_fabricacion")
  List<Vehiculo> findPatenteAndMarcaOrderBy();

  @Query("from Vehiculo v where v.cantidad_de_ruedas=4 and year(v.fecha_fabricacion)=:currentYear")
  List<Vehiculo> findFourWheelsAndCurrentYearVehicles(@Param("currentYear") Integer currentYear);

}
