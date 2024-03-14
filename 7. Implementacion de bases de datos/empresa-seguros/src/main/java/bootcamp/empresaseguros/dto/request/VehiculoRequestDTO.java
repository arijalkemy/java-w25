package bootcamp.empresaseguros.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoRequestDTO {

    String patente;

    String marca;

    String modelo;

    Integer anioDeFabricacion;

    Integer cantidadDeRuedas;

}
