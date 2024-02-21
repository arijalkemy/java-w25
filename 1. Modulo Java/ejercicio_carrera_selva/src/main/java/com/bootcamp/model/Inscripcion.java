package main.java.com.bootcamp.model;

public class Inscripcion {
    private int numeroDeInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoAAbonar;
    public Inscripcion(int numeroDeInscripcion, Categoria categoria, Participante participante ){
        if(categoria.isRestriccionDeEdad() && participante.getEdad() < 18
        ){
            throw new RuntimeException("Participante " + participante.getNombreYApellido()+ " es menor de edad, no se puede realizar la Inscripcion a " + categoria.getNombre());
        }
        this.numeroDeInscripcion = numeroDeInscripcion;
        this.categoria = categoria;
        this.participante =participante;
        this.montoAAbonar = categoria.getPrecioInscripcion(participante.getEdad());
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroDeInscripcion=" + numeroDeInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", montoAAbonar=" + montoAAbonar +
                '}';
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getMontoAAbonar() {
        return montoAAbonar;
    }
}