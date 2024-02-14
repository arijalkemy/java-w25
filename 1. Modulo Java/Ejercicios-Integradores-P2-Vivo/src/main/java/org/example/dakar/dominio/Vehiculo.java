package org.example.dakar.dominio;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public abstract class Vehiculo {

    double velocidad;
    double aceleracion;
    double anguloDeGiro;
    String patente;
    double peso;
    int ruedas;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
