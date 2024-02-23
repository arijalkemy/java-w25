package org.example;

public class Inscripcion {
    private int numeroInscripcion;
    private Participante participante;
    private Categoria categoria;
    public int dineroAbono;

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getDineroAbono() {
        return dineroAbono;
    }

    public void setDineroAbono(int dineroAbono) {
        this.dineroAbono = dineroAbono;
    }

    public Inscripcion(int numeroInscripcion, Participante participante, Categoria categoria) {
        this.numeroInscripcion = numeroInscripcion;
        this.participante = participante;
        this.categoria = categoria;
        this.dineroAbono = calcularMontoInscripcion(participante, categoria);
    }

    private static int calcularMontoInscripcion(Participante participante, Categoria categoria) {
        int dineroAbonado = 0;
        if (participante.getEdad() < 18 && categoria.getNombreCategoria() == "Chico"){
            dineroAbonado = 1300;
        } else if (participante.getEdad() >= 18 && categoria.getNombreCategoria() == "Chico") {
            dineroAbonado = 1500;
        } else if (participante.getEdad() < 18 && categoria.getNombreCategoria() == "Medio") {
            dineroAbonado = 2000;
        } else if (participante.getEdad() >= 18 && categoria.getNombreCategoria() == "Medio") {
            dineroAbonado = 2300;
        } else if (participante.getEdad() >= 18 && categoria.getNombreCategoria() == "Avanzado") {
            dineroAbonado = 2800;
        } else {
            System.out.println("No puede participar en esta categoria");
        }
        return dineroAbonado;
    }
}
