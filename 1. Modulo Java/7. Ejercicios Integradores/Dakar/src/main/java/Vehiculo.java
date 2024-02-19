
public abstract class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private int ruedas;
    private double peso;

    public Vehiculo(
            double velocidad,
            double aceleracion,
            double anguloDeGiro,
            String patente,
            int ruedas,
            double peso
    ) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.ruedas = ruedas;
        this.peso = peso;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public int getRuedas() {
        return ruedas;
    }

    public double getPeso() {
        return peso;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


}
