package org.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportsPeopleDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
