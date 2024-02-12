package Dakar.socorristas;

import Dakar.Carro;

import java.text.MessageFormat;

public class SocorristaCarro extends Carro implements VehiculoSocorrista {
    public SocorristaCarro(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    @Override
    public void socorrerVehiculo(String patente) {
        System.out.println(MessageFormat.format("Socorriendo Carro: {0}",patente));
    }
}
