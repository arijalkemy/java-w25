package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Categoria chico = new Categoria(1,"Circuito chico","2 km por selva y arroyos.");
        Categoria medio = new Categoria(2,"Circuito medio"," 5km por selva, arroyos y barro");
        Categoria grande = new Categoria(3,"Circuito grande","10 km por selva, arroyos, barro y escalada en piedra.");


        Participante unParticipante = new Participante(1,1223,"JUAN", "PEREZ",23,110022,12123,"A+");
        Participante partChicoMenor = new Participante(2, 12345678, "Pepito", "Menguito", 17, 1199220011, 115555444, "A+");
        Participante random1 = new Participante(3, 12162578, "John", "Doe", 30, 1195655011, 115575484, "O+");
        Participante random2 = new Participante(4, 1289484658, "Milena", "madrid", 17, 119568481, 11557784, "O-");

        ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

        Inscripcion inscripcion1 = new Inscripcion(1,medio,unParticipante, calcularInscripcion(medio.getNombre(), unParticipante.getEdad()));
        inscripciones.add(inscripcion1);
        Inscripcion inscripcion2 = new Inscripcion(1,grande,partChicoMenor, calcularInscripcion(chico.getNombre(), partChicoMenor.getEdad()));
        inscripciones.add(inscripcion2);
        Inscripcion inscripcion3 = new Inscripcion(1,medio,unParticipante, calcularInscripcion(chico.getNombre(), unParticipante.getEdad()));
        inscripciones.add(inscripcion3);
        Inscripcion inscripcion4 = new Inscripcion(1,chico,unParticipante, calcularInscripcion(chico.getNombre(), unParticipante.getEdad()));
        inscripciones.add(inscripcion4);

        for (Inscripcion inscripcion : inscripciones) {
            if(inscripcion.getCategoria().getId() == 1) {
                System.out.println("Participante: " + inscripcion.getParticipante().getNombre() + " - Categoria: " + inscripcion.getCategoria().getNombre());
            }
        }

        inscripciones.remove(0);

        for(Inscripcion inscripcion : inscripciones) {
            System.out.println("Categoría: "+inscripcion.getCategoria().getNombre() +" - monto: " +
                    inscripciones.stream().filter(i -> i.getCategoria().getId() == inscripcion.getCategoria().getId())
                            .map(Inscripcion::getMonto).reduce(0, Integer::sum));
        }

        System.out.println("Total: " + inscripciones.stream().map(Inscripcion::getMonto).reduce(0, Integer::sum));

    }

    public static int calcularInscripcion(String nombreCategoria, int edad){
        int monto = 0;
        if (nombreCategoria.equals("Circuito chico")){
            if(edad<18){
                monto = 1300;
            }
            else{monto = 1500;}

        }
        if (nombreCategoria.equals("Circuito medio")){
            if(edad<18){
                monto = 2000;
            }
            else{monto = 2300;}

        }

        if (nombreCategoria.equals("Circuito avanzado")){
            if(edad<18){
                System.out.println("Pequeñin, no te puedes inscribir al circuito avanzado");
            }
            else{monto = 2800;}

        }
        return monto;
    }

}