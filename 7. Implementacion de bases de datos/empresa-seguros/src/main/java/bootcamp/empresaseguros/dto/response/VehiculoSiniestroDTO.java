package bootcamp.empresaseguros.dto.response;

import bootcamp.empresaseguros.entity.Siniestro;
import bootcamp.empresaseguros.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class VehiculoSiniestroDTO {
    private List<Vehiculo> vehiculos;
    private List<Siniestro> siniestros;


}
