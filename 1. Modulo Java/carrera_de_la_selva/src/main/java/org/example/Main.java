package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int count;

    public static void main(String[] args) {

        List<Inscripcion> inscripcions = new ArrayList<>();

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Circuito chico", "2 km por selva y arroyos"));
        categorias.add(new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro"));
        categorias.add(new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra"));

        Participante participante = new Participante(1, "Pepito", "Perez", 23, 123456, 7890123, "O+");
        Participante participante1 = new Participante(2, "Maria", "Lopez", 32, 123456, 7890123, "O+");
        Participante participante2 = new Participante(3, "Jose", "Gomez", 12, 123456, 7890123, "O+");
        Participante participante3 = new Participante(4, "Lucas", "Ramirez", 26, 123456, 7890123, "O+");

        agregarInscripcion(inscripcions, categorias.get(0), participante);
        agregarInscripcion(inscripcions, categorias.get(0), participante1);
        agregarInscripcion(inscripcions, categorias.get(1), participante2);
        agregarInscripcion(inscripcions, categorias.get(2), participante3);

        for (Categoria categoria : categorias) {
            imprimirParticipantes(inscripcions, categoria);
        }

        Inscripcion inscripcionRemover = null;
        for (Inscripcion inscripcion : inscripcions) {
            if(inscripcion.getParticipante().getDni().equals(1)) inscripcionRemover = inscripcion;
        }
        if (inscripcionRemover != null) {
            inscripcions.remove(inscripcionRemover);
            System.out.println("Participante removido");
        }

        for (Categoria categoria : categorias) {
            imprimirParticipantes(inscripcions, categoria);
        }
        for (Categoria categoria : categorias) {
            montoPorCategoria(categoria, inscripcions);
        }

        montoTotal(inscripcions);
    }

    public static void agregarInscripcion(List<Inscripcion> inscripcions , Categoria categoria, Participante participante){
        boolean verificar = true;
        Inscripcion inscripcionNew = null;
        for (Inscripcion inscripcion : inscripcions) {
            if (inscripcion.getCategoria().equals(categoria) && inscripcion.getParticipante().equals(participante)){
                verificar = false;
            }
        }

        if (verificar) inscripcionNew = new Inscripcion(count++, categoria, participante);
        if (inscripcionNew.getMonto() != -1) inscripcions.add(inscripcionNew);
        else System.out.println("No se registro participante");
    }

    public static void imprimirParticipantes(List<Inscripcion> inscripcions, Categoria categoria){

        System.out.println("Participantes de la categoria " + categoria.getNombre() + ": \n");
        for (Inscripcion inscripcion : inscripcions) {
            if (inscripcion.getCategoria().equals(categoria)){
                System.out.println(inscripcion.getParticipante());
                System.out.print(" Numero de inscripcion: " + inscripcion.getNumeroInscripcion() + "\n");
            }
        }
    }

    public static void montoPorCategoria(Categoria categoria, List<Inscripcion> inscripcions){

        int sum = 0;
        for (Inscripcion inscripcion : inscripcions) {
            if (inscripcion.getCategoria().equals(categoria)) {
                sum += inscripcion.getMonto();
            }
        }

        System.out.println("El monto recaudado en la categoria " + categoria.getNombre() + " fue de: " + sum);
    }

    public static void montoTotal(List<Inscripcion> inscripcions){

        int sum = 0;
        for (Inscripcion inscripcion : inscripcions) {
             sum += inscripcion.getMonto();
        }

        System.out.println("El monto total recaudado fue de: " + sum);
    }
}