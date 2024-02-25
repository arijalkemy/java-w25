package org.example;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Ramírez", "jram@email.com", "Veterinario");
        PDF libroPDF = new PDF(456, "Seymour Phillips", "Una noche más en Jupiter", "Ciencia Ficción");
        Informe informe = new Informe("Resumen economía de medio oriente", 34, "Jorge Mendieta", "Estanislao Guzman");

        curriculum.agregarHabilidad("Trabajo en equipo");
        curriculum.agregarHabilidad("Atención al detalle");
        curriculum.agregarHabilidad("Empatía");

        curriculum.imprimir();
        libroPDF.imprimir();
        informe.imprimir();
    }
}