package org.example.modelo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public abstract class Reserva {
    String detalle;
    double precio;
    int cantidad;
    @Override
    public String toString() {
        return "[detalle=" + detalle + ", precio=" + precio + ", cantidad=" + cantidad
                + "]";
    }

    
}
