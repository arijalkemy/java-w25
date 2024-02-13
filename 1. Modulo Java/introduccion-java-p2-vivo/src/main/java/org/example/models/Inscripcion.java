package org.example.models;

public class Inscripcion {
    private int numero;
    private Circuito categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numero, Circuito circuito, Participante participante, double monto){
        this.numero = numero;
        this.categoria = circuito;
        this.participante = participante;
        this.monto = monto;
    }

    public int getNumero(){
        return this.numero;
    }

    public Circuito getCategoria(){
        return this.categoria;
    }

    public Participante getParticipante(){
        return this.participante;
    }

    public double getMonto(){ return this.monto; }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numero=" + numero +
                ", categoria=" + categoria.toString() +
                ", participante=" + participante.toString() +
                ", monto=" + monto +
                '}';
    }
}
