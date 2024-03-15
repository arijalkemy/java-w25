package com.consultashql.repository;

import com.consultashql.model.Siniestro;
import com.consultashql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
    @Query("from Siniestro s where s.perdida_economica > :monto")
    List<Siniestro> findByPerdida_economicaGreaterThanMonto(@Param("monto")Double monto);

}
