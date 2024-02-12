public class SocorristaMoto extends Vehiculo {

    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, int peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Moto moto) {
        System.out.println("Socorriendo Moto " + moto.getPatente());
    }
}
