package meliboot;

public class PdfBook implements IPrinter{
    @Override
    public void Print() {
        System.out.println("Imprimiendo libros con sus atributos, como cantidad de paginas nombre de autor, titulo y genero");
    }
}
