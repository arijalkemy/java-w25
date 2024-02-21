package Impresora;

interface Impresora{
    void imprimir(String mensaje);
    void escanear(String documento);
    String fotocopiar(String texto);
    void enviarCorreo(String destinatario);
}