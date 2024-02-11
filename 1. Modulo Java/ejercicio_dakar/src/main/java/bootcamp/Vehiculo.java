package bootcamp;

public class Vehiculo {
    private double velocidad;
    private double anguloDeGiro;
    private double aceleracion;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo() {
    }
    public double calcularValor(){
        return (this.velocidad * 1/2 * this.aceleracion) / (this.anguloDeGiro * (this.peso -this.ruedas));
    }
    public Vehiculo(double velocidad, double anguloDeGiro, double aceleracion, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.anguloDeGiro = anguloDeGiro;
        this.aceleracion = aceleracion;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", anguloDeGiro=" + anguloDeGiro +
                ", aceleracion=" + aceleracion +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}
