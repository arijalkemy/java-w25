package com.example.classes;

public class Inscripcion {
    private static int contador = 1;
    private int id;
    private Categoria categoria;
    private Participante participante;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.id = Inscripcion.contador++;
        this.categoria = categoria;
        this.participante = participante;

        if (this.participante.getEdad() < 18 && this.categoria.getNombre() == "Circuito Avanzado") {
            System.out.println("El participante no cumple con los requisitos para formar parte de la carrera");
        } else {
            this.categoria.getParticipantes().add(this.participante);
        }

        this.categoria.setTotalGanancias(this.categoria.getTotalGanancias() + this.montoTotalAbonar());
    }

    public int getId() {
        return id;
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

    public int montoTotalAbonar() {
        if (this.participante.getEdad() >= 18) {
            return categoria.getValorMayor();
        }
        return categoria.getValorMenor();
    }

    public void desinscribir() {
        int i = 0;
        for (Participante p : this.categoria.getParticipantes()) {
            if (p.getNumero() == this.participante.getNumero()) {
                this.categoria.getParticipantes().remove(i);
                this.categoria.setTotalGanancias(this.categoria.getTotalGanancias() - this.montoTotalAbonar());
                break;
            }
            i++;
        }
        System.out.println("Participante eliminado de la carrera");
    }

    @Override
    public String toString() {
        return "Inscripcion [id=" + id + ", categoria=" + categoria + ", participante=" + participante + "]";
    }

}
