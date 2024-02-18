import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum(List.of("Java", "Go"));
        Informe informe = new Informe("texto", 1, "autor", "revisor");
        Pdf pdf = new Pdf("texto", 1, "autor", "titulo", "genero");

        curriculum.imprimir();
        informe.imprimir();
        pdf.imprimir();
    }
}
