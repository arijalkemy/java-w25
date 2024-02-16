package org.example;

import org.example.animales.Gato;
import org.example.animales.Perro;
import org.example.animales.Vaca;
import org.example.impresora.Curriculum;
import org.example.impresora.IImprimible;
import org.example.impresora.Informe;
import org.example.impresora.Pdf;
import org.example.transaccion.cliente.Basico;
import org.example.transaccion.cliente.Cliente;
import org.example.transaccion.cliente.Cobrador;
import org.example.transaccion.cliente.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** TRANSACCIONES ***\n\n");
        Ejecutivo ejecutivo = new Ejecutivo("Juan Cárdenas");
        Basico basico = new Basico("Bernando Sánchez");
        Cobrador cobrador = new Cobrador("Julián Martinez");

        System.out.println("*** Ejecutivo ***");
        ejecutivo.depositar();
        ejecutivo.transferir();
        System.out.println("*** Basico ***");
        basico.consultarSaldo();
        basico.retirarEfectivo();
        basico.pagarServicio();
        System.out.println("*** Cobrador ***");
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();


        System.out.println("\n\n*** IMPRIMIBLES ***");
        Curriculum curriculum = new Curriculum("Jhon Luengas", "esteban.921@gmail.com");
        curriculum.nuevaHabilidad("Proactivo");
        curriculum.nuevaHabilidad("Responsable");
        curriculum.nuevaHabilidad("Creativo");
        curriculum.nuevaHabilidad("Organizado");
        Pdf pdf = new Pdf("El general en su laberinto", "Gabriel García Márquex", "Novela", 200);
        Informe informe = new Informe("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas mollis nibh mi, ut pulvinar ipsum.", "Juan Sánchez", "Eduardo Suarez", 150);

        IImprimible.imprimirDocumento(curriculum);
        IImprimible.imprimirDocumento(pdf);
        IImprimible.imprimirDocumento(informe);

        System.out.println("\n\n*** ANIMALES ***");
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        System.out.println("Perro:");
        perro.emitirSonido();
        perro.comer();

        System.out.println("\nGaco");
        gato.emitirSonido();
        gato.comer();

        System.out.println("\nVaca:");
        vaca.emitirSonido();
        vaca.comer();
    }
}