package org.example;

public class Inscripcion {

    private Integer numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private Integer monto;

    public Inscripcion(Integer numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        getValor();
    }

    public Integer getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(Integer numeroInscripcion) {
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

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    private void getValor(){
        if (participante.getEdad() > 18){
            if (categoria.getId().equals(1)) monto = 1500;
            if (categoria.getId().equals(2)) monto = 2300;
            if (categoria.getId().equals(3)) monto = 2800;
        }else {
            if (categoria.getId().equals(1)) monto = 1300;
            if (categoria.getId().equals(2)) monto = 2000;
            if (categoria.getId().equals(3)) monto = -1;
        }
    }
}
