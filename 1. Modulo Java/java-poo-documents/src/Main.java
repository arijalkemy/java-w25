import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum(
                new Person("SAMUEL", "VILLEGAS"),
                List.of(new Habilidad("Correr"), new Habilidad("Saltar"))
        );
        curriculum.imprimir();
        Informe informe = new Informe(new Texto(10, "Hola"), 100, "Samuel", "Daniel");
        informe.imprimir();
        LibroPdf libroPdf = new LibroPdf(10, "Samuel", "libroo","Comedia");
        libroPdf.imprimir();
    }
}