package dakar;

public class Auto extends Vehiculo{

    public Auto() {
    }

    public Auto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, 1000.00, 4);
    }
}
