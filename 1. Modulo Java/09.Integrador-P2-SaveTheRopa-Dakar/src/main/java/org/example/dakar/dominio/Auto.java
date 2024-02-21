package org.example.dakar.dominio;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Auto extends Vehiculo{

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }
}
