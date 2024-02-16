import models.PdfBook;

public class PdfBookPrinter implements IPrint<PdfBook>{

    @java.lang.Override
    public void Print(PdfBook document) {
        System.out.println("Pdf book. Autor: " + document.getNombreAutor() + " Cantidad paginas: " + document.getCantidadPaginas() );
    }
}
