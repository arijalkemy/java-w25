package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Categoria catChico = new Categoria(0,
                "Circuito Chico", "2 km por selva y arroyos.");
        Categoria catMedio = new Categoria(1,
                "Circuito Medio", "5 km por selva, arroyos y barro.");
        Categoria catAvanzado = new Categoria(2,
                "Circuito Avanzado",
                "0 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(
                1, "123456",
                "Juan",
                "Perez",
                 21,
                "+54261234567",
                "+542612345678",
                "B+");
        Participante participante2 = new Participante(
                1, "123456",
                "Juan",
                "Perez",
                 21,
                "+54261234567",
                "+542612345678",
                "B+");
        Participante participante3 = new Participante(
                1, "123456",
                "Juan",
                "Perez",
                 21,
                "+54261234567",
                "+542612345678",
                "B+");
        List<Inscripcion> inscripcionList = new ArrayList<>();

        Inscripcion inscripcion1 = new Inscripcion(1, catChico, participante1);
        Inscripcion inscripcion2 = new Inscripcion(1, catMedio, participante2);
        Inscripcion inscripcion3 = new Inscripcion(1, catAvanzado, participante3);

        inscripcionList.add(inscripcion1);
        inscripcionList.add(inscripcion2);
        inscripcionList.add(inscripcion3);

        System.out.println("Monto a pagar " + inscripcion1.getMonto());
        System.out.println("Monto a pagar " + inscripcion2.getMonto());
        System.out.println("Monto a pagar " + inscripcion3.getMonto());

        System.out.println("Inscriptos a Circuito Chico");
        mostrarPorCategoria(0,inscripcionList);
        System.out.println("Inscriptos a Circuito Medio");
        mostrarPorCategoria(1,inscripcionList);
        System.out.println("Inscriptos a Circuito Largo");
        mostrarPorCategoria(2,inscripcionList);

        System.out.println("Monto total por Circuito Chico " + montoPorCategoria(0, inscripcionList));
        System.out.println("Monto total por Circuito Medio " + montoPorCategoria(1, inscripcionList));
        System.out.println("Monto total por Circuito Largo " + montoPorCategoria(2, inscripcionList));

        System.out.println("Total recaudado carreras " + montoTotal(inscripcionList));


    }

    private static void mostrarPorCategoria(Integer idCat, List<Inscripcion> inscripcionList){
        //0 circuito chico
        //1 circuito medio
        //2 circuito grande
        for (Inscripcion i : inscripcionList){
            if(i.getCategoria().getId().equals(idCat)){
                System.out.println("Numero Inscripcion: " +i.getNumeroInscripcion());
                System.out.println(i.getParticipante());
            }
        }
    }

    private static double montoPorCategoria(Integer idCat, List<Inscripcion> inscripcionList){
        //0 circuito chico
        //1 circuito medio
        //2 circuito grande
        double monto = 0.0;
        for (Inscripcion i : inscripcionList){
            if(i.getCategoria().getId().equals(idCat) && i.getMonto() > 0){
                monto+=i.getMonto();
            }
        }
        return monto;
    }

    private static double montoTotal(List<Inscripcion> inscripcionList){
        //0 circuito chico
        //1 circuito medio
        //2 circuito grande
        double monto = 0.0;
        for (Inscripcion i : inscripcionList){
            if(i.getMonto() > 0){
                monto+=i.getMonto();
            }
        }
        return monto;
    }
}