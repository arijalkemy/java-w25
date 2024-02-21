package models;

public class Moto extends Vehiculo{

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300d, 2);
    }
    
}
