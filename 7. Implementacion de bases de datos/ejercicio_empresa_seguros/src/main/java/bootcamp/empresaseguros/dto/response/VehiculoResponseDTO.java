package bootcamp.empresaseguros.dto.response;

import bootcamp.empresaseguros.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehiculoResponseDTO {

    Long id;

    String patente;

    String marca;

    String modelo;

    Integer anioDeFabricacion;

    Integer cantidadDeRuedas;

    public VehiculoResponseDTO(Vehiculo v) {
        this.id = v.getId();
        this.patente = v.getPatente();
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.anioDeFabricacion = v.getAnioDeFabricacion();
        this.cantidadDeRuedas = v.getCantidadDeRuedas();
    }

}
