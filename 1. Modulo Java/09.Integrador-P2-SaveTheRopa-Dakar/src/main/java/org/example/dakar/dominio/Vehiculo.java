package org.example.dakar.dominio;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public abstract class Vehiculo {

    double velocidad;
    double aceleracion;
    double anguloDeGiro;
    String patente;
    double peso;
    int ruedas;

}
