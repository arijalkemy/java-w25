package org.example;

import org.example.ejercicio1.clientes.Basic;
import org.example.ejercicio1.clientes.Cobrador;
import org.example.ejercicio1.clientes.Ejecutivo;
import org.example.ejercicio2.clases.BookPdf;
import org.example.ejercicio2.clases.Person;
import org.example.ejercicio2.clases.Report;
import org.example.ejercicio2.clases.Resume;
import org.example.ejercicio2.interfaces.IPrintable;
import org.example.ejercicio3.clases.Gato;
import org.example.ejercicio3.clases.Perro;
import org.example.ejercicio3.clases.Vaca;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1
//        Ejecutivo ejecutivo = new Ejecutivo();
//        ejecutivo.deposit(false);
//
//        Basic basic = new Basic();
//        basic.pay(true);
//
//        Cobrador cobrador = new Cobrador();
//        cobrador.consult(false);

        // Ejercicio 2
//        BookPdf bookPdf = new BookPdf(256, "J.K Rowling", "Harry Potter", "Fantasy");
//        Report report = new Report(12, 25, "John Doe", "Lil Wayne");
//        Resume resume = new Resume(new Person("Nicolás", "Aimar", 28));
//
//        resume.addSkills("Programming");
//        resume.addSkills("Financial Advising");
//        resume.addSkills("CrossFit");
//
//        IPrintable.printDocument(bookPdf);
//        System.out.println();
//
//        IPrintable.printDocument(report);
//        System.out.println();
//
//        IPrintable.printDocument(resume);

        // Ejercicio 3
        Perro firulais = new Perro();
        firulais.comerCarne();
        firulais.emitirSonido();

        System.out.println();

        Gato gato = new Gato();
        gato.comerCarne();
        gato.emitirSonido();

        System.out.println();

        Vaca vaca = new Vaca();
        vaca.comerHierba();
        vaca.emitirSonido();
    }
}