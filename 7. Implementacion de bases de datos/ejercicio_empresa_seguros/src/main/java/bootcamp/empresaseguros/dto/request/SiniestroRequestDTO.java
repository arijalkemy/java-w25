package bootcamp.empresaseguros.dto.request;

import bootcamp.empresaseguros.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroRequestDTO {
    LocalDate fecha;
    double perdidaEconomica;
    Long vehiculoId;
}
