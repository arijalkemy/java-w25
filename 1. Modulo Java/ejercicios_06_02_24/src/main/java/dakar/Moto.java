package dakar;

public class Moto extends Vehiculo{
    public Moto() {
    }

    public Moto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, 300.00, 2);
    }
}
