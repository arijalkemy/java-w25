package org.example;

import java.util.ArrayList;

public class Inscripcion{
    public int getNumero_inscripcion() {
        return numero_inscripcion;
    }

    public void setNumero_inscripcion(int numero_inscripcion) {
        this.numero_inscripcion = numero_inscripcion;
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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    int numero_inscripcion;
    Categoria categoria;
    Participante participante;
    int monto;
    public Inscripcion(int numero_inscripcion,Categoria categoria,Participante participante, int monto){
        this.numero_inscripcion= numero_inscripcion;
        this.categoria= categoria;
        this.participante=  participante;
        this.monto=  monto;

        if (categoria.getNombre().equals("Circuito chico")){
            if(participante.getEdad()<18){
                this.monto = 1300;
            }
            else{this.monto = 1500;}

        }
        if (categoria.getNombre().equals("Circuito medio")){
            if(participante.getEdad()<18){
                this.monto = 2000;
            }
            else{this.monto = 2300;}

        }

        if (categoria.getNombre().equals("Circuito avanzado")){
            if(participante.getEdad()<18){
                System.out.println("Pequeñin, no te puedes inscribir al circuito avanzado");
            }
            else{this.monto = 2800;}

        }


    }

}
