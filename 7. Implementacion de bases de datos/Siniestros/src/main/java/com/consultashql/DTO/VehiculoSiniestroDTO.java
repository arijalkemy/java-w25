package com.consultashql.DTO;

import com.consultashql.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSiniestroDTO {
    private List<VehiculoDTO> vehiculos;
    private Double total;

}
