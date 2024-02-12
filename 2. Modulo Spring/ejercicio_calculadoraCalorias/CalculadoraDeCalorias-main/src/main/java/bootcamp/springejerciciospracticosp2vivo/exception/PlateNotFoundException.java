package bootcamp.springejerciciospracticosp2vivo.exception;

public class PlateNotFoundException extends Exception {

    public PlateNotFoundException(String name) {
        super(String.format("The plate '" + name + "' was not found."));
    }

}
