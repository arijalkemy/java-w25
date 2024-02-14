package bootcamp.dtoresponseentityp2.exception;

public class NoSymptomException extends Exception {

    public NoSymptomException(String name) {
        super(String.format("No se encuentra el síntoma '%s'", name));
    }

}
