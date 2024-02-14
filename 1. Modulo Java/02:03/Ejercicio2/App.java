import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Informe informe1 = new Informe("lecuenocnce einwoncwd woncoanw", "autor1", "revisor1", 50);
        LibroPDF libroPDF1 = new LibroPDF(20, "autor2", "titulo1", "genero1");

        informe1.mostrarContenido();
        libroPDF1.mostrarContenido();
    }
}
