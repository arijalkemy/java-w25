public class Carro extends Vehiculo{

    private static final int CANTIDAD_RUEDAS = 4;
    private static final double PESO = 1000;
    public Carro(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, CANTIDAD_RUEDAS, PESO);
    }
}
