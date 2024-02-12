package Dakar.socorristas;

import Dakar.Moto;

import java.text.MessageFormat;

public class SocorristaMoto extends Moto implements VehiculoSocorrista {
    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    @Override
    public void socorrerVehiculo(String patente) {
        System.out.println(MessageFormat.format("Socorriendo Moto: {0}",patente));
    }
}
