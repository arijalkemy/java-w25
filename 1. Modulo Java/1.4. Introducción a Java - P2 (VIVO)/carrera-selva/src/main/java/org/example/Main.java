package org.example;

public class Main {
    public static void main(String[] args) {
        Participante p1 = new Participante(1, 12345678, "Juan", "Perez", 17, 123456789, 987654321, "A+");
        Participante p2 = new Participante(2, 87654321, "Maria", "Gomez", 19, 987654321, 123456789, "B-");
        Participante p3 = new Participante(3, 13579246, "Pedro", "Martinez", 21, 135792468, 864197532, "AB+");
        Participante p4 = new Participante(4, 24681357, "Jose", "Lopez", 17, 246813579, 975312648, "O-");
        Participante p5 = new Participante(5, 35792468, "Ana", "Sanchez", 19, 357924681, 864197532, "A-");
        Participante p6 = new Participante(6, 46813579, "Laura", "Gonzalez", 21, 468135792, 975312648, "B+");

        p1.inscribir(1, Categoria.CIRCUITO_CHICO);
        p2.inscribir(2, Categoria.CIRCUITO_MEDIO);
        p3.inscribir(3, Categoria.CIRCUITO_AVANZADO);
        p4.inscribir(4, Categoria.CIRCUITO_CHICO);
        p5.inscribir(5, Categoria.CIRCUITO_MEDIO);
        p6.inscribir(6, Categoria.CIRCUITO_AVANZADO);

        Inscripcion.mostrarInscritos(Categoria.CIRCUITO_AVANZADO);
        p6.desinscribir();
        Inscripcion.mostrarInscritos(Categoria.CIRCUITO_AVANZADO);

        Inscripcion.calcularMontos();
    }
}