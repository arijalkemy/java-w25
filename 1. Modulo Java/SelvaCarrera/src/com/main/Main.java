package com.main;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Participantes> listaParticipantes = new ArrayList<Participantes>();
        ArrayList<Inscripciones> listaInscripciones = new ArrayList<Inscripciones>();

        Categoria circuitoChico = new Categoria(2, new String[] {"Selva", "Arroyo"});
        Categoria circuitoMedio = new Categoria(5, new String[] {"Selva","Arroyos","Barro"});
        Categoria circuitoAvanzado = new Categoria(10, new String[]{"Selva","Arroyos","Barro","Escalada"});


        listaParticipantes.add(new Participantes(1,"56575657","Samuel","Acosta",21,"23242434","465362736","O+","CC"));
        listaParticipantes.add(new Participantes(2,"76767676","Daniela","Muñoz",17,"61212124","343434344","O-","CM"));
        listaParticipantes.add(new Participantes(3,"54545454","Juan","Lopez",30,"9078767","876509090","O+","CA"));
        listaParticipantes.add(new Participantes(4,"93939393","Laura","Perez",16,"99229292","43543657","A+","CC"));

        for (Participantes participante : listaParticipantes) {
            if (participante.getCategoria()=="CC"){
                if (participante.getEdad()<18){
                    listaInscripciones.add(new Inscripciones(participante.getCategoria(),participante.getNumPart(),1300));
                    System.out.println("El monto a abonar es: $"+1300);
                }else {
                    listaInscripciones.add(new Inscripciones(participante.getCategoria(),participante.getNumPart(),1500));
                    System.out.println("El monto a abonar es: $"+1500);
                }
            }
            if (participante.getCategoria()=="CM"){
                if (participante.getEdad()<18){
                    listaInscripciones.add(new Inscripciones(participante.getCategoria(),participante.getNumPart(),2000));
                    System.out.println("El monto a abonar es: $"+2000);
                }else {
                    listaInscripciones.add(new Inscripciones(participante.getCategoria(),participante.getNumPart(),2300));
                    System.out.println("El monto a abonar es: $"+2300);
                }
            }
            if (participante.getCategoria()=="CA"){
                if (participante.getEdad()<18){
                    System.out.println("No se permiten inscripciones a menores de edad.");
                }else {
                    listaInscripciones.add(new Inscripciones(participante.getCategoria(),participante.getNumPart(),2800));
                    System.out.println("El monto a abonar es: $"+2800);
                }
            }
            //System.out.println(participante.toString());
        }

        System.out.print("\nPARTICIPANTES EN CIRCUITO CHICO:\n");
        for (Participantes participante : listaParticipantes) {
            if (participante.getCategoria()=="CC"){
                System.out.println(participante.toString());
            }
        }
        System.out.print("\nLISTA DE PARTICIPANTES:\n");
        for (Participantes participante : listaParticipantes) {
            System.out.println(participante.toString());
        }

        //Eliminar objeto
        String elimParticipante = "54545454";
        Participantes objeto = null;
        for (Participantes participante : listaParticipantes) {
            if (participante.getDni().equals(elimParticipante)) {
                objeto = participante;
                break;
            }
        }

        if (objeto != null) {
            listaParticipantes.remove(objeto);
            System.out.println("\nParticipante eliminado: " + objeto.getNombre());
        } else {
            System.out.println("\nParticipante no encontrado para eliminar.");
        }

        System.out.print("\nLISTA DE PARTICIPANTES:\n");
        for (Participantes participante : listaParticipantes) {
            System.out.println(participante.toString());
        }

        System.out.print("\nMONTOS RECAUDADOS:\n");
        int totalCC=0;
        int totalCM=0;
        int totalCA=0;
        for (Inscripciones inscripcion : listaInscripciones) {
            if(inscripcion.getCategoria()=="CC"){
                totalCC=totalCC+inscripcion.getMonto();
            }
            if(inscripcion.getCategoria()=="CM"){
                totalCM=totalCM+inscripcion.getMonto();
            }
            if(inscripcion.getCategoria()=="CA"){
                totalCA=totalCA+inscripcion.getMonto();
            }
            //System.out.println(inscripcion.toString());
        }
        System.out.println("Circuito Chico: $"+totalCC);
        System.out.println("Circuito Medio: $"+totalCM);
        System.out.println("Circuito Avanzado: $"+totalCA);
        System.out.println("Total: $"+(totalCC+totalCA+totalCM));
    }
}
