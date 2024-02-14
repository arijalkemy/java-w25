package classes;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double peso;
    private int ruedas;
    private int anguloDeGiro;
    private String patente;

    public Vehiculo(double velocidad, double aceleracion, double peso, int ruedas, int anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.peso = peso;
        this.ruedas = ruedas;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public int getAnguloDeGiro() {
        return anguloDeGiro;
    }

    @Override
    public String toString() {
        return "Vehiculo [velocidad=" + velocidad + ", aceleracion=" + aceleracion + ", peso=" + peso + ", ruedas="
                + ruedas + ", anguloDeGiro=" + anguloDeGiro + ", patente=" + patente + "]";
    }

}
