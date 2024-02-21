package Impresora;

public class Main {
    public static void main(String[] args) {
        AccionarImpresora impresora = new AccionarImpresora();
        impresora.imprimir("Hola mundo");
        impresora.escanear("Cedula.pdf");
        String fotocopia = impresora.fotocopiar(String.valueOf(15+5));
        impresora.imprimir(fotocopia);
        impresora.enviarCorreo("holamundo@gmail.com");
    }
}
