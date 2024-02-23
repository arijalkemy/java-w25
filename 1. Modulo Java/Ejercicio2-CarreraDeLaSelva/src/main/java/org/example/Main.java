package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    protected static List<Categoria> listaCategorias;
    public static void main(String[] args) {
        //Creacion de los objetos de cada categoria y una lista para ir almacenando
        listaCategorias = new ArrayList<>();
        listaCategorias.add(new Categoria(0, "Chico",2,
                "Por selva y arroyos"));
        listaCategorias.add(new Categoria(1, "Medio",5,
                "Por selva, arroyos y barro"));
        listaCategorias.add(new Categoria(2, "Avanzado",10,
                "Por selva, arroyos, barro y escalado en piedra"));

        //Creacion de participantes y listado de participantes
        List<Participante> listaParticipantes = new ArrayList<>();
        listaParticipantes.add(new Participante(0, 1234, "Fabian",
                "Castillo", 21, 321321,123,"A+"));
        listaParticipantes.add(new Participante(1,5678, "Carolina",
                "Henriquez", 29, 321567, 321, "O+"));
        listaParticipantes.add(new Participante(2, 9012, "Luis",
                "Cano", 17, 321890, 231, "O-"));
        listaParticipantes.add(new Participante(3, 3456, "Manuela",
                "Ruiz", 19, 321123, 312, "O-"));

        //Creacion de listado con los inscritos
        List<Inscripcion> listaInscritos = new ArrayList<>();
        listaInscritos.add(new Inscripcion(0,
                listaParticipantes.get(0), listaCategorias.get(0)));
        listaInscritos.add(new Inscripcion(1,
                listaParticipantes.get(1), listaCategorias.get(1)));
        listaInscritos.add(new Inscripcion(2,
                listaParticipantes.get(2), listaCategorias.get(2)));
        listaInscritos.add(new Inscripcion(3,
                listaParticipantes.get(3), listaCategorias.get(2)));
        listaInscritos.add(new Inscripcion(3,
                listaParticipantes.get(3), listaCategorias.get(1)));

        //Mostrar todos los inscritos por categoria
        mostrarInscritos(listaInscritos);

        //Desinscribir a un participante
        desinscribirParticipante(listaInscritos, 3);

        //Monto total carrera y monto por categoria
        calcularMontoTotal(listaInscritos);
        calcularMontoPorcategoria(listaInscritos);

    }
    private static void mostrarInscritos(List<Inscripcion> listaInscritos){
        List<Inscripcion> listaCircuitoChico = new ArrayList<>();
        List<Inscripcion> listaCircuitoMedio = new ArrayList<>();
        List<Inscripcion> listaCircuitoAvanzado = new ArrayList<>();
        for (Inscripcion participanteInscrito : listaInscritos){
            if (participanteInscrito.getCategoria().getId() == listaCategorias.get(0).getId()){
                listaCircuitoChico.add(participanteInscrito);
            } else if (participanteInscrito.getCategoria().getId() == listaCategorias.get(1).getId()) {
                listaCircuitoAvanzado.add(participanteInscrito);
            } else if (participanteInscrito.getCategoria().getId() == listaCategorias.get(2).getId()) {
                listaCircuitoAvanzado.add(participanteInscrito);
            }
        }
        System.out.println("Los participantes inscritos al circuito corto son: ");
        listaCircuitoChico.forEach(participanteInscrito -> System.out.println(
                "Numero del participante: "+ participanteInscrito.getNumeroInscripcion() +
                        ". "+ participanteInscrito.getParticipante().toString()));
        System.out.println("Los participantes inscritos al circuito medio son: ");
        listaCircuitoMedio.forEach(participanteInscrito -> System.out.println(
                "Numero del participante: "+ participanteInscrito.getNumeroInscripcion() +
                        ". "+ participanteInscrito.getParticipante().toString()));
        System.out.println("Los participantes inscritos al circuito avanzado son: ");
        listaCircuitoAvanzado.forEach(participanteInscrito -> System.out.println(
                "Numero del participante: "+ participanteInscrito.getNumeroInscripcion() +
                        ". "+ participanteInscrito.getParticipante().toString()));
    }

    private static void desinscribirParticipante(List<Inscripcion> listaInscritos, int idParticipante){
        List<Inscripcion> listaDesuscritos = new ArrayList<>();
        for (Inscripcion inscrito : listaInscritos){
            if (inscrito.getParticipante().getNumeroParticipante() == idParticipante) {
                listaDesuscritos.add(inscrito);
            }
        }
        listaInscritos.removeIf(inscrito -> inscrito.getParticipante().getNumeroParticipante() == idParticipante);
        System.out.println("El participante con id "+ idParticipante +" ha sido desinscrito de todas las categorias");
        listaDesuscritos.forEach(inscrito -> {
            mostrarInscritosPorIdCategoria(listaInscritos, inscrito.getCategoria().getId());
        });
    }

    private static void mostrarInscritosPorIdCategoria(List<Inscripcion> listaInscritos, int idCategoria) {
        System.out.println("Las inscripciones por categoria: "+ listaCategorias.get(idCategoria).getNombreCategoria());
        listaInscritos.forEach(inscrito -> {
            if (inscrito.getCategoria().getId() == idCategoria) {
                System.out.println("El participante inscrito con el numero "+inscrito.getNumeroInscripcion() +
                        ": "+inscrito.getParticipante().toString());
            }
        });
    }

    private static void calcularMontoTotal(List<Inscripcion> listaInscritos) {
        int montoTotal = 0;
        for (Inscripcion inscrito : listaInscritos) {
            montoTotal += inscrito.getDineroAbono();
        }
        System.out.println("El monto total de la carrera es: " + montoTotal);
    }

    private static void calcularMontoPorcategoria(List<Inscripcion> listaInscritos) {
        List<Integer> montosCategoria = new ArrayList<>(List.of(0, 0, 0));
        listaInscritos.forEach(inscrito -> {
            montosCategoria.set(inscrito.getCategoria().getId(), inscrito.getDineroAbono()+montosCategoria.get(inscrito.getCategoria().getId()));
        });
        System.out.println("El monto total por categoria es: ");
        listaCategorias.forEach(categoria -> {
            System.out.println(categoria.getNombreCategoria()+": "+montosCategoria.get(categoria.getId()));
        });
    }
}