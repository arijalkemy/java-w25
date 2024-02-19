public class Moto extends Vehiculo{

    private static final int CANTIDAD_RUEDAS = 2;
    private static final double PESO = 300;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, CANTIDAD_RUEDAS, PESO);
    }
}