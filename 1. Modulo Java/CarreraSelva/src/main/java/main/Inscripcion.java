package main;

import java.util.*;

public class Inscripcion {
    private int numero;
    private Map<Circuito, Integer> categoria = new HashMap<>();
    private Participante participante;
    private double monto;

    public Inscripcion(int numero, Map<Circuito, Integer> categoria, Participante participante, double monto) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }
}
