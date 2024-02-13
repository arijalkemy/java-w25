package org.example.concesionariaautos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    private String fecha;
    private double kilometros;
    private String descripcion;
}
