package bootcamp.recapitulandospringp2vivo.exception;

public class InvalidLinkException extends RuntimeException {

    public InvalidLinkException() {
        super("Link inválido.");
    }

}
