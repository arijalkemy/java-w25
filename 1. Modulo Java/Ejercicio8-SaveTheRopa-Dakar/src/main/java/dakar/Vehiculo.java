package dakar;

public abstract class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Integer anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;

    public Vehiculo(Double velocidad, Double aceleracion, Integer anguloDeGiro, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public Integer getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }
}
