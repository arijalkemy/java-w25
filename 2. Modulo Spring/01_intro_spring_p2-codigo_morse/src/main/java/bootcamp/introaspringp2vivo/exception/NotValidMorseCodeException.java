package bootcamp.introaspringp2vivo.exception;

public class NotValidMorseCodeException extends RuntimeException {

    public NotValidMorseCodeException(String morseCode) {
        super(String.format("Código morse no válido: %s", morseCode));
    }

}
