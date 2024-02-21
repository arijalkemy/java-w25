package Ejercicio_Carrera_Selva;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private List<Inscripcion> inscripciones;

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inscripciones = new ArrayList<>();
    }

    public void agregarInscripto(Inscripcion inscripcion) {
        this.inscripciones.add(inscripcion);
    }

    public void removerInscripcion(Inscripcion inscripcion) {
        this.inscripciones.remove(inscripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public double calcularMontoTotal() {
        double montoFinal = 0;
        for(Inscripcion ins : this.inscripciones) {
            montoFinal += ins.getMontoAbonar();
        }
        return montoFinal;
    }
}
