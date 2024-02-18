import java.util.Comparator;

public abstract class Vehiculo{
    private float velocidad;
    private float aceleracion;
    private float anguloDeGiro;
    private String patente;
    private float peso;
    private int ruedas;

    public Vehiculo(float velocidad, float aceleracion, float anguloDeGiro, String patente, float peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(float aceleracion) {
        this.aceleracion = aceleracion;
    }

    public float getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(float anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                ", puntaje=" + this.getVelocidad()*(0.5*this.getAceleracion())/(this.getAnguloDeGiro()*(this.getPeso()-this.getRuedas()*100.0)) +
                '}';
    }
}