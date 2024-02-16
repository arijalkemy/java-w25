import models.PdfBook;

public class Main {
    public static void main(String[] args) {
        PdfBook book = new PdfBook(120, "Juan", "El olvido", "Drama");
        PdfBookPrinter pdfBookPrinter = new PdfBookPrinter();
        pdfBookPrinter.Print(book);
    }
}

