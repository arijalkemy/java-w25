package org.example;
public class Inscripcion {
    private Integer numeroInscripcion;
    private Categoria categoria;
    private Double monto;
    private Participante participante;

    public Inscripcion(Integer numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    private double calcularMonto(){
        //Menores a 18
        if(this.participante.getEdad() < 18){
            if(this.categoria.getId().equals(0)) return 1300;
            if(this.categoria.getId().equals(1)) return 2000;
            if(this.categoria.getId().equals(2)) return -1;
        }else{ //Mayores o igual a 18
            if(this.categoria.getId().equals(0)) return 1500;
            if(this.categoria.getId().equals(1)) return 1300;
            if(this.categoria.getId().equals(2)) return 2800;
        }
        return -1;
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}
