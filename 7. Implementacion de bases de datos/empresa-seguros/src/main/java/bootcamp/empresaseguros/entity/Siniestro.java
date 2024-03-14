package bootcamp.empresaseguros.entity;

import bootcamp.empresaseguros.dto.request.VehiculoRequestDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "siniestros")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Siniestro  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long Id;
    LocalDateTime fecha;
    double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "vehiculo_denunciado_id")
    Vehiculo vehiculo;

}
