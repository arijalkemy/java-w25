import java.util.HashMap;
import java.util.Map;

public class Circuito {

    // atributos
    private int id;
    private String nombre;
    private String descripcion;
    private final int edadMenores = 18;
    private double montoMenores;
    private double montoMayores;

    // Constructor
    public Circuito(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setMontoMenores(double montoMenores) {
        this.montoMenores = montoMenores;
    }

    public void setMontoMayores(double montoMayores) {
        this.montoMayores = montoMayores;
    }

    public int getEdadMenores() {
        return edadMenores;
    }

    public double getMontoMenores() {
        return montoMenores;
    }

    public double getMontoMayores() {
        return montoMayores;
    }

    public double calcularMonto (int edad) {
        return (edad > edadMenores) ? montoMayores : montoMenores;
    }

    public int getId() {
        return id;
    }
}
