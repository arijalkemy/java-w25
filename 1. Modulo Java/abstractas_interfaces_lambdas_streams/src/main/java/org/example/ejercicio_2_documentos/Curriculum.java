package org.example.ejercicio_2_documentos;


import javax.swing.plaf.synth.SynthTextAreaUI;

public class Curriculum implements IImprimir{
    private String nombre;
    private  int edad;
    private  String hablidades;

    public Curriculum(String nombre, int edad, String hablidades){
        this.nombre = nombre;
        this.edad = edad;
        this.hablidades = hablidades;
    }
    @Override
    public  void imprimir(){
        System.out.println("Imprimir  CV");
    }
}

