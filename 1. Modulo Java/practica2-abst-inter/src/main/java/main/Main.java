package main;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Curriculum curriculum = new Curriculum("Juan Giraldo", 22, "juan123@gmail.com", "AWS, Docker, Java");
        LibroPDF libro = new LibroPDF(324, "Jose Mendoza", "Ciudad tóxica", "Terror psicológico");
        Informe informe = new Informe("Evaluación general de la Wave 25 del Bootcamp Java", 12, "Carlos Caicedo", "Martin Zamora");

        imprimir(curriculum);
        imprimir(libro);
        imprimir(informe);


    }

    public static void imprimir(Imprimible archivo){
        archivo.imprimir();
    }

}