package bootcamp.recapitulandospringp2vivo.exception;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException() {
        super("La contraseña recibida es incorrecta.");
    }

}
