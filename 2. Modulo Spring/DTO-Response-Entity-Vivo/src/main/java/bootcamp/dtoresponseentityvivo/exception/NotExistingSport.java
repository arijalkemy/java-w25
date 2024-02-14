package bootcamp.dtoresponseentityvivo.exception;

public class NotExistingSport extends Exception {

    public NotExistingSport(String sport) {
        super(String.format("No existe el deporte '%s'", sport));
    }

}
