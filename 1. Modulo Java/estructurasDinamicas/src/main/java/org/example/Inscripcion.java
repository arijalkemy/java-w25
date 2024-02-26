package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inscripcion {
    private static List<Inscripcion> repo = new ArrayList<>();
    private static int cantInscripciones = 0;
    private int numInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(){
        Inscripcion.cantInscripciones += 1;
        this.numInscripcion = Inscripcion.cantInscripciones;
        repo.add(this);
    }

    public static List<Inscripcion> getRepo() {
        return repo;
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

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public static int getCantInscripciones() {
        return cantInscripciones;
    }

    public int getNumInscripcion() {
        return numInscripcion;
    }

    public double getMonto() {
        return monto;
    }

    public List<Inscripcion> findAll(){
        return repo;
    }
    public void remove(){
        for (int i = 0; i < repo.size(); i++){
            if (repo.get(i).equals(this)){
                repo.remove(this);
            }
        }
    };

    public static String totalRecaudado(){
        Map<String, Double> calculo = new HashMap<>();
        for (Inscripcion i: repo){
            if( calculo.containsKey(i.getCategoria().getNombre())){
                calculo.put(i.getCategoria().getNombre(),
                        calculo.get(i.getCategoria().getNombre()) + i.getMonto());
            }else{
                calculo.put(i.getCategoria().getNombre(), i.getMonto());
            }
        }
        double total = 0;
        String sFinal = "";
        for (Map.Entry<String,Double> i: calculo.entrySet()){
            total += i.getValue();
            sFinal += "La categoria " + i.getKey() + " recaudo " + i.getValue() + "\n";
        }

        sFinal += "Y en total se recaudo " + total;
        return sFinal;
    }

    public static void mostrarCategoria(String nombre){
        for (Inscripcion i: repo){
            if (nombre.equals(i.getCategoria().getNombre())){
                System.out.println(i.getParticipante());
            }
        }
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numInscripcion=" + numInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }
}
