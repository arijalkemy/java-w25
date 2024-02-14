package org.example.dakar.dominio;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Moto extends Vehiculo{

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "velocidad=" + getVelocidad() +
                ", aceleracion=" + getAceleracion() +
                ", anguloDeGiro=" + getAnguloDeGiro() +
                ", patente='" + getPatente() + '\'' +
                ", peso=" + getPeso() +
                ", ruedas=" + getRuedas() +
                '}';
    }
}
