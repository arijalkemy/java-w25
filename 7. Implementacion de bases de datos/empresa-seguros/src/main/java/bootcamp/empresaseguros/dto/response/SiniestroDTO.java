package bootcamp.empresaseguros.dto.response;

import bootcamp.empresaseguros.entity.Vehiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDTO {

    Long Id;
    LocalDateTime fecha;
    double perdidaEconomica;
    Long vehiculoId;

}
