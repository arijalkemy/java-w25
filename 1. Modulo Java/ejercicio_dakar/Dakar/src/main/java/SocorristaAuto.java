public class SocorristaAuto extends Vehiculo {
    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente, int peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Auto auto) {
        System.out.println("Socorriendo Auto " + auto.getPatente());
    }
}
