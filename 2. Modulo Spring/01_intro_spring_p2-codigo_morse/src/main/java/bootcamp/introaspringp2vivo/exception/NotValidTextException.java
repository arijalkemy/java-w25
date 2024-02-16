package bootcamp.introaspringp2vivo.exception;

public class NotValidTextException extends RuntimeException {

    public NotValidTextException(String character) {
        super(String.format("Caracter no válido: %s", character));
    }

}