package bootcamp.empresaseguros.repository;

import bootcamp.empresaseguros.dto.response.PatenteMarcaModeloDTO;
import bootcamp.empresaseguros.dto.response.VehiculoSiniestroDTO;
import bootcamp.empresaseguros.entity.Siniestro;
import bootcamp.empresaseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
    @Query("SELECT s.vehiculo FROM Siniestro s WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> findByPerdida();

    @Query("SELECT s.vehiculo.patente,s.vehiculo.marca,s.vehiculo.modelo, SUM(s.perdidaEconomica) FROM Siniestro s WHERE s.perdidaEconomica > 10000 GROUP BY s.vehiculo.id")
    List<Object[]> findByPerdidaAndTotalSum();
}
