package com.carrera;

import java.util.HashMap;
import java.util.Map;

class PreciosCategoria {
    private Integer valorMin, valorMax;

    public PreciosCategoria(int valorMin, int valorMax) {
        this.valorMin = valorMin;
        this.valorMax = valorMax;
    }

    public PreciosCategoria(int valorMax) {
        this.valorMin = -1;
        this.valorMax = valorMax;
    }

    public Integer getValorMin() {
        return valorMin;
    }

    public Integer getValorMax() {
        return valorMax;
    }

    @Override
    public String toString() {
        return String.format("Min. %s - Máx. %s", this.valorMin, this.valorMax);
    }
}


class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private PreciosCategoria preciosCategoria;
    private static int totalCategorias = 0;

    public Categoria(String nombre, String descripcion, PreciosCategoria preciosCategoria) {
        this.id = ++totalCategorias;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preciosCategoria = preciosCategoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public PreciosCategoria getPreciosCategoria() {
        return preciosCategoria;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion
                + ", preciosCategoria=" + preciosCategoria + "]";
    }


}


class Participante {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;

    public Participante(int dni, String nombre, String apellido, int edad, String celular,
        String numeroEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCelular() {
        return celular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    @Override
    public String toString() {
        return "[dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
                + ", celular=" + celular + ", numeroEmergencia=" + numeroEmergencia
                + ", grupoSanguineo=" + grupoSanguineo + "]";
    }


}


class Inscripcion {
    private int id;
    private Categoria categoria;
    private int monto;
    private static int totalInscripciones = 0;
    private Participante participante;


    public Inscripcion(Categoria categoria, Participante participante) throws Exception {
        this.id = ++totalInscripciones;
        this.categoria = categoria;
        this.participante = participante;
        this.setMonto();
    }


    public int getId() {
        return id;
    }


    public Categoria getCategoria() {
        return categoria;
    }


    public int getMonto() {
        return monto;
    }


    private void setMonto() throws Exception {
        PreciosCategoria precios = this.categoria.getPreciosCategoria();
        if (this.participante.getEdad() < 18) {
            if (precios.getValorMin() == -1) {
                throw new Exception(
                        "No se permiten inscripciones a menores de 18 años para esta categoria."
                );
            }

            this.monto = precios.getValorMin();
        }

        this.monto = precios.getValorMax();
    }


    public static int getTotalInscripciones() {
        return totalInscripciones;
    }


    public static void setTotalInscripciones(int totalInscripciones) {
        Inscripcion.totalInscripciones = totalInscripciones;
    }


    public Participante getParticipante() {
        return participante;
    }


    public void setParticipante(Participante participante) {
        this.participante = participante;
    }


    @Override
    public String toString() {
        return "ID de inscripcion: " + id + "\nCategoria: " + categoria + "\nMonto: " + monto
                + "\nParticipante: " + participante + "]";
    }
}


class Inscripciones extends HashMap<Integer, Inscripcion> {
    public void nuevaInscripcion(Inscripcion inscripcion) {
        this.put(Integer.valueOf(inscripcion.getParticipante().getDni()), inscripcion);
    }

    public void getInscripcionesPorCategoria(Categoria categoria) {
        System.out.println("------");
        System.out.println("Inscripciones por categoria: " + categoria.getNombre());
        System.out.println("------");
        for (Map.Entry<Integer, Inscripcion> entry : this.entrySet()) {
            Inscripcion inscripcion = entry.getValue();
            if (inscripcion.getCategoria().equals(categoria)) {
                System.out.println(inscripcion);
                System.out.println("------");
            }
        }
    }

    public void getInscripciones() {
        for (Map.Entry<Integer, Inscripcion> entry : this.entrySet()) {
            Inscripcion inscripcion = entry.getValue();
            System.out.println(inscripcion);
            System.out.println("------");
        }
    }

    public void borrarInscripcion(Integer idParticipante) {
        Categoria categoria = this.get(idParticipante).getCategoria();
        this.remove(idParticipante);
        System.out.println("Borrado participante " + idParticipante + " (Categoria "
                + categoria.getNombre() + ")");
        this.getInscripcionesPorCategoria(categoria);
    }

    public void getMontoCategoria(Categoria categoria) {
        int monto = 0;
        for (Map.Entry<Integer, Inscripcion> entry : this.entrySet()) {
            Inscripcion inscripcion = entry.getValue();
            if (inscripcion.getCategoria().equals(categoria)) {
                monto += inscripcion.getMonto();
            }
        }
        System.out.println("------");
        System.out.println("Monto total de la categoria '" + categoria.getNombre() + "': " + monto);
    }

    public void getMontoTotal() {
        int monto = 0;
        for (Map.Entry<Integer, Inscripcion> entry : this.entrySet()) {
            Inscripcion inscripcion = entry.getValue();
            monto += inscripcion.getMonto();
        }
        System.out.println("------");
        System.out.println("Monto total de toda la carrera: " + monto);
    }
}


public class App {
    public static void main(String[] args) throws Exception {

        // CREAR 3 OBJETOS DE TIPO CATEGORÍA (UNO POR CADA CATEGORÍA) CON SUS RESPECTIVOS DATOS.

        // Precios por categoria
        PreciosCategoria precioChico = new PreciosCategoria(1300, 1500);
        PreciosCategoria precioMedio = new PreciosCategoria(2000, 2300);
        PreciosCategoria precioAvanzado = new PreciosCategoria(2800);

        // Definicion de categorias
        Categoria circuitoChico = new Categoria(
                "Circuito chico",
                "2 km por selva y arroyos",
                precioChico
        );
        Categoria circuitoMedio = new Categoria(
                "Circuito medio",
                "5 km por selva, arroyos y barro",
                precioMedio
        );
        Categoria circuitoAvanzado = new Categoria(
                "Circuito avanzado",
                "10 km por selva, arroyos y escalada en piedra",
                precioAvanzado
        );

        // CREAR UN NUEVO PARTICIPANTE E INSCRIBIRLO EN UNA CATEGORÍA. CALCULAR EL MONTO DE
        // INSCRIPCIÓN QUE DEBERÁ ABONAR (POR EJEMPLO: SI EL PARTICIPANTE SE INSCRIBE A LA CATEGORÍA
        // CIRCUITO CHICO Y TIENE 21 AÑOS, EL MONTO A ABONAR ES DE $1500).

        // Creacion de participante
        Participante participante1 = new Participante(
                11111,
                "Juan",
                "Lozano",
                18,
                "3102394856",
                "3102394857",
                "O+"
        );

        // Inscripcion de participante
        Inscripciones inscripciones = new Inscripciones();
        Inscripcion inscripcion1 = new Inscripcion(circuitoAvanzado, participante1);
        inscripciones.nuevaInscripcion(inscripcion1);
        System.out.println("##### 1 #####");
        inscripciones.getInscripciones();

        // INSCRIBIR AL AZAR ALGUNOS PARTICIPANTES EN DIFERENTES CATEGORÍAS (AL MENOS UNO EN CADA
        // UNA).

        Participante participante2 = new Participante(
                11111323,
                "Jhonn",
                "Luengas",
                27,
                "3232394856",
                "3142394857",
                "A-"
        );

        Participante participante3 = new Participante(
                11111312,
                "Luis",
                "Garzón",
                16,
                "3232394856",
                "3142394857",
                "AB+");

        Participante participante4 = new Participante(
                1112,
                "Luisa",
                "Garnica",
                31,
                "3452394856",
                "3562394857",
                "O-"
        );

        // Inscripcion de participante
        Inscripcion inscripcion2 = new Inscripcion(circuitoMedio, participante2);
        inscripciones.nuevaInscripcion(inscripcion2);
        Inscripcion inscripcion3 = new Inscripcion(circuitoMedio, participante3);
        inscripciones.nuevaInscripcion(inscripcion3);
        Inscripcion inscripcion4 = new Inscripcion(circuitoChico, participante4);
        inscripciones.nuevaInscripcion(inscripcion4);

        // MOSTRAR POR PANTALLA TODOS LOS INSCRIPTOS A UNA DETERMINADA CATEGORÍA CON SUS
        // CORRESPONDIENTES DATOS Y NÚMERO DE INSCRIPCIÓN.

        System.out.println("##### 2 #####");
        System.out.println("\n+++++ TODAS LAS INSCRIPCIONES +++++\n");
        inscripciones.getInscripciones();
        System.out.println("\n+++++ POR CATEGORIA +++++\n");
        inscripciones.getInscripcionesPorCategoria(circuitoChico);
        inscripciones.getInscripcionesPorCategoria(circuitoMedio);
        inscripciones.getInscripcionesPorCategoria(circuitoAvanzado);


        // DESINSCRIBIR A UN PARTICIPANTE. MOSTRAR COMO QUEDA LA LISTA DE INSCRIPTOS EN LA CATEGORÍA
        // DONDE SE ENCONTRABA.
        inscripciones.borrarInscripcion(participante2.getDni());

        // CALCULAR EL MONTO TOTAL RECAUDADO POR CADA CATEGORÍA Y EL TOTAL DE TODA LA CARRERA
        // INCLUYENDO TODAS LAS CATEGORÍAS.
        inscripciones.getMontoCategoria(circuitoChico);
        inscripciones.getMontoCategoria(circuitoMedio);
        inscripciones.getMontoCategoria(circuitoAvanzado);
        inscripciones.getMontoTotal();
    }
}
