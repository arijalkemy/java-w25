package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Juan Perez","Java,C++,Python");
        LibroPDF libro = new LibroPDF(200,"Gabriel Garcia Marquez","Cien años de soledad","Novela");
        Informe informe = new Informe("Texto del informe",10,"Autor del informe","Revisor del informe");

        Impresora.imprimirDocumento(cv);
        Impresora.imprimirDocumento(libro);
        Impresora.imprimirDocumento(informe);
    }
}