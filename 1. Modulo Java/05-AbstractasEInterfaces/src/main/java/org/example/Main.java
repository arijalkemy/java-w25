package org.example;

import org.example.banco.clientes.Basic;
import org.example.banco.clientes.Cobradores;
import org.example.banco.clientes.Ejecutivos;
import org.example.granja.Animal;
import org.example.granja.Gato;
import org.example.granja.Perro;
import org.example.granja.Vaca;
import org.example.impresora.Imprimible;
import org.example.impresora.Informes;
import org.example.impresora.LibroPDF;
import org.example.impresora.curriculum;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Basic clienteBasico = new Basic();
        Cobradores cobrador = new Cobradores();
        Ejecutivos ejecutivos = new Ejecutivos();

        clienteBasico.pagoServiciosNoOk();
        cobrador.retiroEfectivoOk();
        ejecutivos.depositoOk();

        Imprimible curriculum = new curriculum("Luis perez ..... datos", List.of("Social","Servicial","Honesto"));
        Imprimible libroPdf = new LibroPDF(625,"Brandon sanderson","Nacidos de la Bruma","Fantasia");

        Imprimible informes = new Informes("lorem ipsum cvstodies......texto.....mas text",25,"Juan Gutierrez","Andres Alvarez");

        curriculum.printDocument();
        libroPdf.printDocument();
        informes.printDocument();


        Gato gato = new Gato("Perla");
        Perro perro = new Perro("Canela");
        Vaca vaca = new Vaca("Sofia");

        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

        vaca.comerHierba();
        gato.comerCarne();
        perro.comerCarne();

        gato.comerAnimal(vaca);




    }
}