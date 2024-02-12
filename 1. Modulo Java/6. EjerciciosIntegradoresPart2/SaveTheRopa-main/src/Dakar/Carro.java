package Dakar;

public class Carro extends Vehiculo{
    public Carro(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        setPeso(1000.0);
        setRuedas(4);

    }

}
