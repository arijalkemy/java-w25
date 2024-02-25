package meliboot;

public class Main {
    public static void main(String[] args) {
        IPrinter curriculum = new Curriculum();
        IPrinter pdfBook = new PdfBook();
        IPrinter report = new Report();
        toPrint(curriculum);
        toPrint(pdfBook);
        toPrint(report);

    }

    public static void toPrint(IPrinter document){
        document.Print();
    }
}