package bootcamp.empresaseguros.dto.response;

import bootcamp.empresaseguros.entity.Vehiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDTO {

    Long Id;
    LocalDate fecha;
    double perdidaEconomica;
    Vehiculo vehiculo;

}
