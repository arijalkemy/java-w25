package ejer.linktracker.exception;

public class LinkNotAvailableException extends RuntimeException{
    public LinkNotAvailableException() {
    }

    public LinkNotAvailableException(String message) {
        super(message);
    }
}
