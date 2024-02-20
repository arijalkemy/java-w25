package org.example.models;

public class Inscripcion {
   private int numeroInscripcion;
   private Categoria categoria;
   private Participante participante;
   private Double monto;

    public Inscripcion() {
    }

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public double calcularMonto() {
        double monto;
        int edad = participante.getEdad();
        if (categoria.getId() == 1) {
            if (edad < 18) {
                monto = 1300;
            } else {
                monto = 1500;
            }
        } else if (categoria.getId() == 2) {
            if (edad < 18) {
                monto = 2000;
            } else {
                monto = 2300;
            }
        } else {
            if(edad<18){
                monto = 0;
            }else{
                monto = 2800;
            }
        }
        return monto;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + controlEdad(participante.getEdad(), monto) +
                '}';
    }

    public String controlEdad(int edad,double monto){
        if(edad<18 && categoria.getId()==3){
            return "No se permite inscripciones a menores de 18 años.";
        }else{
            return String.valueOf(monto);
        }
    }
}
