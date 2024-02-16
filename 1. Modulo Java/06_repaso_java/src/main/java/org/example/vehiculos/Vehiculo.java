package org.example.vehiculos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehiculo {
    String marca;
    String modelo;
    int precio;
    int anio;

    public Vehiculo aplicarDescuento(int descuento){
        return new Vehiculo(this.marca, this.modelo, this.precio - descuento, this.anio);
    }

    @Override
    public String toString(){
        return this.marca + " " + this.modelo + " ($" + this.precio + ")";
    }
}
