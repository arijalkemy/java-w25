package bootcamp.empresaseguros.repository;

import bootcamp.empresaseguros.dto.response.PatenteDTO;
import bootcamp.empresaseguros.dto.response.PatenteMarcaDTO;
import bootcamp.empresaseguros.dto.response.PatenteMarcaModeloDTO;
import bootcamp.empresaseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<PatenteDTO> getAllVehiclesLicensePlates();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioDeFabricacion DESC")
    List<PatenteMarcaDTO> getAllVehiclesLicensePlatesAndBrandOrderedByYearOfManufacturingDesc();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadDeRuedas > 4 AND v.anioDeFabricacion = :currentYear")
    List<PatenteDTO> getVehiclesLicensePlateWithMoreThan4WheelsAndYearOfManufacturingCurrentYear(@Param("currentYear") Integer currentYear);

}
