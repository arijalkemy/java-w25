package org.bootcamp.ejercicio2;

import org.bootcamp.ejercicio2.interfaces.IPrintable;
import org.bootcamp.ejercicio2.model.BookPdf;
import org.bootcamp.ejercicio2.model.Report;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookPdf bookPdf = new BookPdf("BookPdf","Gabriel Garcia Marquez","Cien años ...","Novela",100);
        IPrintable.print(bookPdf);

        Report report = new Report("Report","Fenomeno del niño...",10,"Emmanuel","Alejandro");
        IPrintable.print(report);
    }
}