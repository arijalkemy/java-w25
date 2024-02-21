package Impresora;

public class AccionarImpresora implements Impresora {

    @Override
    public void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("El documento " + documento + " ha sido escaneado");
    }

    @Override
    public String fotocopiar(String texto) {
        return texto;
    }

    @Override
    public void enviarCorreo(String destinatario) {
        System.out.println("Correo electronid enviado a: " + destinatario);
    }

    

    
}
