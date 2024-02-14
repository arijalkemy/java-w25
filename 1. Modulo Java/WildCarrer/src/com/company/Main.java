package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //1.
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        //2
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        Participante participante1 = new Participante(
                1,
                1000,
                "Daniel",
                "Cortazar",
                18,
                300000000,
                300000000,
                "O+"
        );

        //3

        Participante participante2 = new Participante(
                2,
                1000,
                "Ramona",
                "Cortazar",
                18,
                300000000,
                300000000,
                "O+"
        );

        Participante participante3 = new Participante(
                3,
                1000,
                "Batman",
                "Cardona",
                18,
                300000000,
                300000000,
                "O+"
        );

        Participante participante4 = new Participante(
                3,
                1000,
                "Lotarino",
                "Cardona",
                18,
                300000000,
                300000000,
                "O+"
        );

        //3
        participante1.inscribir(circuitoChico);
        participante2.inscribir(circuitoMedio);
        participante3.inscribir(circuitoAvanzado);
        participante4.inscribir(circuitoChico);

        inscripciones.add(new Inscripcion(1, circuitoChico, participante1));
        inscripciones.add(new Inscripcion(2, circuitoMedio, participante2));
        inscripciones.add(new Inscripcion(1, circuitoAvanzado, participante3));
        inscripciones.add(new Inscripcion(1, circuitoAvanzado, participante4));

        //4
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println(String.format("Inscripción #%s en " + inscripcion.categoria.nombre + " Nombre participante: " + inscripcion.participante.nombre, inscripcion.numInscripcion));
        }

        //5
        inscripciones.remove(1);
        System.out.println("Lista de participantes luego de la desinscripcion");
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println(String.format("Inscripción #%s en " + inscripcion.categoria.nombre + " Nombre participante: " + inscripcion.participante.nombre, inscripcion.numInscripcion));
        }

        //6
        System.out.println("Monto por categoria:");
        double totalCategoriaChico = 0;
        double totalCategoriaMedio = 0;
        double totalCategoriaAvanzado = 0;
        for (Inscripcion inscripcion : inscripciones) {
            switch (inscripcion.categoria.nombre) {
                case "Circuito Chico":
                    totalCategoriaChico += inscripcion.tarifa;
                    break;
                case "Circuito Medio":
                    totalCategoriaMedio += inscripcion.tarifa;
                    break;
                case "Circuito Avanzado":
                    totalCategoriaAvanzado += inscripcion.tarifa;
                    break;
            }
        }

        double total = totalCategoriaAvanzado + totalCategoriaChico + totalCategoriaMedio;

        System.out.println("Circuito Chico TOTAL: " + totalCategoriaChico);
        System.out.println("Circuito Medio TOTAL: " + totalCategoriaMedio);
        System.out.println("Circuito Avanzado TOTAL: " + totalCategoriaAvanzado);
        System.out.println("TOTAL carrera: " + total);
    }
}

    class Participante {
        public int numParticipante;
        public int dni;
        public String nombre;
        public String apellido;
        public int edad;
        public long celular;
        public long numEmergencia;
        public String grupoSanguineo;
        public Categoria categoria;

        public Participante(int numParticipante, int dni, String nombre, String apellido, int edad, long celular, long numEmergencia, String grupoSanguineo) {
            this.numParticipante = numParticipante;
            this.dni = dni;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.celular = celular;
            this.numEmergencia = numEmergencia;
            this.grupoSanguineo = grupoSanguineo;
        }

        public void inscribir(Categoria categoria) {
            this.categoria = categoria;
        }
    }

    class Categoria {
        public int id;
        public String nombre;
        public String descripcion;
        public ArrayList<Inscripcion> inscripciones;

        public Categoria(
                int id,
                String nombre,
                String descripcion
        ) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
        }
    }

    class Inscripcion {
        public int numInscripcion;
        public Categoria categoria;
        public Participante participante;
        public double tarifa;

        public Inscripcion(int numInscripcion, Categoria categoria, Participante participante) {
            this.numInscripcion = numInscripcion;
            this.categoria = categoria;
            this.participante = participante;
            this.calcularTarifa();
        }

        private void calcularTarifa() {
            if (this.categoria.id == 1) {
                this.tarifa = this.participante.edad > 18 ? 1500 : 1300;
                return;
            }

            if (this.categoria.id == 2) {
                this.tarifa = this.participante.edad > 18 ? 2300 : 2000;
                return;
            }

            this.tarifa = this.participante.edad >= 18 ? 2800 : 0;
        }
    }

