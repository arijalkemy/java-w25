package ejercicio.blog.demo.exceptions;

public class EntradaNotFoundException extends RuntimeException {
    public EntradaNotFoundException(String message) {
        super(message);
    }
}
